package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from ThreadSafeSingleton!", ThreadSafeSingleton.getInstance().hello());
    }

    public String hello() {
        return ("Hello from ThreadSafeSingleton!");
    }
}