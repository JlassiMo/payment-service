package com.example.paymentservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "external.payment")
public class PaymentProviderProperties {

    private String paypalUrl;
    private String stripeUrl;
    private String squareUrl;

    // Getters and setters
    public String getPaypalUrl() {
        return paypalUrl;
    }

    public void setPaypalUrl(String paypalUrl) {
        this.paypalUrl = paypalUrl;
    }

    public String getStripeUrl() {
        return stripeUrl;
    }

    public void setStripeUrl(String stripeUrl) {
        this.stripeUrl = stripeUrl;
    }

    public String getSquareUrl() {
        return squareUrl;
    }

    public void setSquareUrl(String squareUrl) {
        this.squareUrl = squareUrl;
    }
}
