package com.example.paymentservice.provider;

import com.example.paymentservice.model.PaymentRequest;
import org.springframework.stereotype.Component;


public interface PaymentProvider {
    void processPayment(PaymentRequest request);
}
