package com.example.paymentservice.observer;

import com.example.paymentservice.model.PaymentTransaction;
import org.springframework.stereotype.Component;

@Component
public class NotificationObserver implements Observer {
    @Override
    public void update(PaymentTransaction transaction) {
        System.out.println("Sending notification for transaction: " + transaction);
    }
}
