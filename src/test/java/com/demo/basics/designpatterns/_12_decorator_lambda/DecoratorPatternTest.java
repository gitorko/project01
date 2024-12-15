package com.demo.basics.designpatterns._12_decorator_lambda;

import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

interface Pizza {
    String getDescription();

    Double getCost();
}

public class DecoratorPatternTest {

    @Test
    public void test() {
        Pizza doubleCheesePizza = new Cheese(new Cheese(new BasicPizza()));
        Assertions.assertEquals(14.0, doubleCheesePizza.getCost());
    }
}

class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public Double getCost() {
        return 10.0;
    }
}

class PizzaToppingDecorator implements Pizza {
    private final Pizza pizza;

    public PizzaToppingDecorator(Pizza pizza, Function<Pizza, Pizza> topping) {
        this.pizza = topping.apply(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public Double getCost() {
        return pizza.getCost();
    }
}

class Cheese extends PizzaToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza,
                p -> new Pizza() {
                    @Override
                    public String getDescription() {
                        return p.getDescription() + " + Cheese";
                    }

                    @Override
                    public Double getCost() {
                        return p.getCost() + 2.0;
                    }
                });
    }
}

