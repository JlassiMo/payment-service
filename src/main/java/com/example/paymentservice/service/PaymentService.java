package com.example.paymentservice.service;

import com.example.paymentservice.model.PaymentProviderType;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.model.PaymentTransaction;
import com.example.paymentservice.observer.Observer;
import com.example.paymentservice.observer.Subject;
import com.example.paymentservice.provider.PaymentProvider;
import com.example.paymentservice.provider.PaymentProviderFactory;
import com.example.paymentservice.repository.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService implements Subject {
    private PaymentProvider paymentProvider;
    private final List<Observer> observers = new ArrayList<>();

    @Autowired
    private PaymentProviderFactory paymentProviderFactory;

    @Autowired
    private PaymentTransactionRepository transactionRepository;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    public void setPaymentProvider(PaymentProviderType providerType) {
        this.paymentProvider = paymentProviderFactory.getPaymentProvider(providerType);
    }

    public void processPayment(PaymentRequest request) {
        if (paymentProvider == null) {
            throw new IllegalStateException("Payment provider not set");
        }

        // Check for fraud
        boolean isFraudulent = fraudDetectionService.isFraudulent(request.getAmount());
        if (isFraudulent) {
            throw new IllegalArgumentException("Fraudulent transaction detected");
        }

        // Process payment using the provider
        paymentProvider.processPayment(request);

        // Save transaction
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setProvider(paymentProvider.getClass().getSimpleName());
        transaction.setAmount(request.getAmount());
        transaction.setSuccessful(true);
        transactionRepository.save(transaction);

        // Notify observers
        notifyObservers(transaction);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(PaymentTransaction transaction) {
        for (Observer observer : observers) {
            observer.update(transaction);
        }
    }
}
