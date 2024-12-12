package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EagerLoadedSingleton {

    private static final EagerLoadedSingleton instance = new EagerLoadedSingleton();

    private EagerLoadedSingleton() {
    }

    public static EagerLoadedSingleton getInstance() {
        return instance;
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from EagerLoadedSingleton!", EagerLoadedSingleton.getInstance().hello());
    }

    public String hello() {
        return ("Hello from EagerLoadedSingleton!");
    }
}
