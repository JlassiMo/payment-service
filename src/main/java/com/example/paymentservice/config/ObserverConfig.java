package com.example.paymentservice.config;

import com.example.paymentservice.observer.LoggingObserver;
import com.example.paymentservice.observer.AnalyticsObserver;
import com.example.paymentservice.observer.NotificationObserver;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ObserverConfig {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private LoggingObserver loggingObserver;

    @Autowired
    private AnalyticsObserver analyticsObserver;

    @Autowired
    private NotificationObserver notificationObserver;

    @PostConstruct
    public void init() {
        paymentService.registerObserver(loggingObserver);
        paymentService.registerObserver(analyticsObserver);
        paymentService.registerObserver(notificationObserver);
    }
}
