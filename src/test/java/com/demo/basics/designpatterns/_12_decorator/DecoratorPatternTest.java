package com.demo.basics.designpatterns._12_decorator;

import lombok.AllArgsConstructor;
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

@AllArgsConstructor
class PizzaToppingDecorator implements Pizza {

    Pizza pizza;

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
        super(pizza);
    }

    @Override
    public Double getCost() {
        return (pizza.getCost() + 2.0);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }
}
