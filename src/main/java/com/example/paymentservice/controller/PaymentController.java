package com.example.paymentservice.controller;

import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/payments")
@Validated
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        paymentService.setPaymentProvider(paymentRequest.getProvider());
        paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(String.format( "%s payment processed successfully", paymentRequest.getProvider()));
    }
}
