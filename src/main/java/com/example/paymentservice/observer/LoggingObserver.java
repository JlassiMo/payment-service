package com.example.paymentservice.observer;

import com.example.paymentservice.model.PaymentTransaction;
import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements Observer {
    @Override
    public void update(PaymentTransaction transaction) {
        System.out.println("Logging transaction: " + transaction);
    }
}
