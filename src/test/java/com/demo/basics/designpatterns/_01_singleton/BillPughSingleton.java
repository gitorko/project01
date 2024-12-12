package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BillPughSingleton {

    private BillPughSingleton() {
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Test
    public void test() {
        Assertions.assertEquals("Hello from BillPughSingleton!", BillPughSingleton.getInstance().hello());
    }

    public String hello() {
        return "Hello from BillPughSingleton!";
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}
