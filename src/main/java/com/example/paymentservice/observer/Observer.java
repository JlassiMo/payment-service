package com.example.paymentservice.observer;

import com.example.paymentservice.model.PaymentTransaction;

public interface Observer {
    void update(PaymentTransaction transaction);
}
