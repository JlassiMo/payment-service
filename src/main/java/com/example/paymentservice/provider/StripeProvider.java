package com.example.paymentservice.provider;

import com.example.paymentservice.config.PaymentProviderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class StripeProvider implements PaymentProvider {

    private final WebClient webClient;
    private final String url;

    @Autowired
    public StripeProvider(WebClient.Builder webClientBuilder, PaymentProviderProperties properties) {
        this.url = properties.getStripeUrl();
        this.webClient = webClientBuilder.baseUrl(this.url).build();
    }

    @Override
    public void processPayment(double amount) {
        // Example request to Stripe API
        webClient.post()
                .uri("")
                .bodyValue(createPaymentRequest(amount))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private Object createPaymentRequest(double amount) {
        // Create and return the request payload for Stripe
        return new Object(); // Replace with actual request object
    }
}
