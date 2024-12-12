package com.demo.basics.designpatterns._17_stategy;

import org.junit.jupiter.api.Test;

interface PaymentStrategy {
    void pay(int amount);
}

public class StrategyPatternTest {

    @Test
    public void test() {
        new ShoppingCart().pay(new CreditCardStrategy(), 10);
        new ShoppingCart().pay(new PaypalStrategy(), 10);
    }
}

class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid by credit card: " + amount);
    }

}

class PaypalStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid by paypal: " + amount);
    }

}

class ShoppingCart {

    public void pay(PaymentStrategy paymentMethod, Integer amount) {
        paymentMethod.pay(amount);
    }
}
