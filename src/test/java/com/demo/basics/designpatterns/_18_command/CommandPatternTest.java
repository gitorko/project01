package com.demo.basics.designpatterns._18_command;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

interface Command {
    void execute();
}

public class CommandPatternTest {

    @Test
    public void test() {

        Stock stock1 = new Stock("GOOGL", 10);
        Stock stock2 = new Stock("IBM", 20);

        BuyStock buyStockCmd = new BuyStock(stock1);
        SellStock sellStockCmd = new SellStock(stock2);

        Broker broker = new Broker();
        broker.takeOrder(buyStockCmd);
        broker.takeOrder(sellStockCmd);

        broker.placeOrders();
    }
}

@AllArgsConstructor
class Stock {

    private String name;
    private int quantity;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

@AllArgsConstructor
class BuyStock implements Command {
    private Stock stock;

    public void execute() {
        stock.buy();
    }
}

@AllArgsConstructor
class SellStock implements Command {
    private Stock stock;

    public void execute() {
        stock.sell();
    }
}

class Broker {
    private List<Command> cmdLst = new ArrayList<Command>();

    public void takeOrder(Command cmd) {
        cmdLst.add(cmd);
    }

    public void placeOrders() {
        for (Command cmd : cmdLst) {
            cmd.execute();
        }
        cmdLst.clear();
    }
}