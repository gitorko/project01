package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumSingleton {

    @Test
    public void test() {
        Assertions.assertEquals("Hello from EnumSingleton!", EnumSingleClass.INSTANCE.hello());
    }

    enum EnumSingleClass {
        INSTANCE;

        public String hello() {
            return ("Hello from EnumSingleton!");
        }
    }
}
