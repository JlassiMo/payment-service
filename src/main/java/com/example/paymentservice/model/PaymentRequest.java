package com.example.paymentservice.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PaymentRequest {

    @NotNull(message = "Provider is mandatory")
    private PaymentProviderType provider;

    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private double amount;

    // Getters and setters
    public PaymentProviderType getProvider() {
        return provider;
    }

    public void setProvider(PaymentProviderType provider) {
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
