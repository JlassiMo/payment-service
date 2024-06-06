package com.example.paymentservice.provider;

import com.example.paymentservice.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SquareProvider implements PaymentProvider {

    @Value("${external.payment.providers.square.url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void processPayment(PaymentRequest request) {
        restTemplate.postForObject(url, request, String.class);
    }
}
