package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LazyLoadedSingleton {

    private static LazyLoadedSingleton instance;

    private LazyLoadedSingleton() {
    }

    public static LazyLoadedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyLoadedSingleton();
        }
        return instance;
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from LazyLoadedSingleton!", LazyLoadedSingleton.getInstance().hello());
    }

    public String hello() {
        return ("Hello from LazyLoadedSingleton!");
    }
}
