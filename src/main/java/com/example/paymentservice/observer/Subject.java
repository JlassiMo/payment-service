package com.example.paymentservice.observer;

import com.example.paymentservice.model.PaymentTransaction;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(PaymentTransaction transaction);
}
