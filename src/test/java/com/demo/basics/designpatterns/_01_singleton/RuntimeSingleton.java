package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Test;

public class RuntimeSingleton {
    @Test
    public void test() {
        Runtime singleton1 = Runtime.getRuntime();
        singleton1.gc();
        Runtime singleton2 = Runtime.getRuntime();
        if (singleton1 == singleton2) {
            System.out.println("Singleton!");
        } else {
            System.out.println("Not Singleton!");
        }
    }
}
