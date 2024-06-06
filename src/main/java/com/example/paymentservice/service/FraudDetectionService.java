package com.example.paymentservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class FraudDetectionService {
    private final WebClient webClient;

    public FraudDetectionService(@Value("${external.fraud-service-url}") String fraudServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(fraudServiceUrl)
                .build();
    }

    public boolean isFraudulent(double amount) {
        return Boolean.TRUE.equals(webClient.post()
                .uri("/check")
                .bodyValue(amount)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}
