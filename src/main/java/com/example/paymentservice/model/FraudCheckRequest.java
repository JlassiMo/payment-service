package com.example.paymentservice.model;

public class FraudCheckRequest {
    private double amount;

    public FraudCheckRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}