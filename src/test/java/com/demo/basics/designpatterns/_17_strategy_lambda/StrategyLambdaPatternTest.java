package com.demo.basics.designpatterns._17_strategy_lambda;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

public class StrategyLambdaPatternTest {
    @Test
    public void test() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Consumer<Integer> creditCard = (amount) -> System.out.println("Paid by credit card: " + amount);
        Consumer<Integer> payPal = (amount) -> System.out.println("Paid by paypal: " + amount);

        shoppingCart.pay(creditCard, 10);
        shoppingCart.pay(payPal, 10);
    }

}

class ShoppingCart {
    public void pay(Consumer<Integer> payMethod, Integer amount) {
        payMethod.accept(amount);
    }
}