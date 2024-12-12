package com.demo.basics.designpatterns._16_observer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

interface Observer {
    void notify(String tick);
}

interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers(String tick);
}

public class ObserverPatternTest {

    @Test
    public void test() {
        Feed feed = new Feed();
        feed.registerObserver(new AppleStockObserver());
        feed.registerObserver(new GoogleStockObserver());
        feed.notifyObservers("APPL: 162.33");
        feed.notifyObservers("GOOGL: 1031.22");
    }
}

class AppleStockObserver implements Observer {
    @Override
    public void notify(String tick) {
        if (tick != null && tick.contains("APPL")) {
            System.out.println("Apple Stock Price: " + tick);
        }
    }
}

class GoogleStockObserver implements Observer {
    @Override
    public void notify(String tick) {
        if (tick != null && tick.contains("GOOGL")) {
            System.out.println("Google Stock Price: " + tick);
        }
    }
}

class Feed implements Subject {
    List<Observer> observerLst = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerLst.add(observer);
    }

    @Override
    public void notifyObservers(String tick) {
        observerLst.forEach(e -> e.notify(tick));
    }
}