package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StaticBlockSingleton {

    private static final StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    private StaticBlockSingleton() {
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from StaticBlockSingleton!", StaticBlockSingleton.getInstance().hello());
    }

    public String hello() {
        return ("Hello from StaticBlockSingleton!");
    }
}
