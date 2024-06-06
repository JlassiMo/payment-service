package com.example.paymentservice.controller;

import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/payments")
@Validated
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public void processPayment(@Valid @ModelAttribute PaymentRequest paymentRequest) {
        paymentService.setPaymentProvider(paymentRequest.getProvider());
        paymentService.processPayment(paymentRequest.getAmount());
    }
}
