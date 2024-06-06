package com.example.paymentservice.provider;

import com.example.paymentservice.model.PaymentProviderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class PaymentProviderFactory {

    private final Map<PaymentProviderType, PaymentProvider> paymentProviders = new EnumMap<>(PaymentProviderType.class);

    @Autowired
    public PaymentProviderFactory(PayPalProvider payPalPaymentProvider,
                                  StripeProvider stripePaymentProvider,
                                  SquareProvider squarePaymentProvider) {
        paymentProviders.put(PaymentProviderType.PAYPAL, payPalPaymentProvider);
        paymentProviders.put(PaymentProviderType.STRIPE, stripePaymentProvider);
        paymentProviders.put(PaymentProviderType.SQUARE, squarePaymentProvider);
    }

    public PaymentProvider getPaymentProvider(PaymentProviderType providerType) {
        PaymentProvider provider = paymentProviders.get(providerType);
        if (provider == null) {
            throw new IllegalArgumentException("No payment provider found for type: " + providerType);
        }
        return provider;
    }
}
