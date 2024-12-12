package com.demo.basics.designpatterns._20_visitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

interface Visitable {
    double accept(Visitor visitor);
}

interface Visitor {
    double visit(Liquor item);

    double visit(Grocery item);
}

public class VisitorPatternTest {
    @Test
    public void test() {

        Visitor taxCalculator = new TaxVisitor();
        Liquor liquor = new Liquor("Vodka", 12.00d);
        System.out.println("Price of liquor: " + liquor.accept(taxCalculator));

        Grocery grocery = new Grocery("Potato Chips", 12.00d);
        System.out.println("Price of grocery: " + grocery.accept(taxCalculator));

    }
}

@AllArgsConstructor
@Data
class Liquor implements Visitable {
    String name;
    double price;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

@AllArgsConstructor
@Data
class Grocery implements Visitable {
    String name;
    double price;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class TaxVisitor implements Visitor {

    @Override
    public double visit(Liquor item) {
        return item.price * .30 + item.price;
    }

    @Override
    public double visit(Grocery item) {
        return item.price * .10 + item.price;
    }
}
