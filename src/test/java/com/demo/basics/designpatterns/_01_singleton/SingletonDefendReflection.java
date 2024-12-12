package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonDefendReflection {

    private static volatile SingletonDefendReflection instance;

    private SingletonDefendReflection() {
        if (instance != null) {
            throw new RuntimeException("Use get instance to create object!");
        }
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from ThreadSafeSingleton!", SingletonDefendReflection.getInstance().hello());
    }

    public static SingletonDefendReflection getInstance() {
        if (instance == null) {
            synchronized (SingletonDefendReflection.class) {
                if (instance == null) {
                    instance = new SingletonDefendReflection();
                }
            }
        }
        return instance;
    }

    public String hello() {
        return ("Hello from ThreadSafeSingleton!");
    }
}
