package com.demo.basics.java._31_switch;

import org.junit.jupiter.api.Test;

public class SwitchOps {

    @Test
    void test() {
        Object instance = new Dev("Jack", 30);
        switch (instance) {
            case Dev(var name, var age) -> {
                System.out.println("Name: " + name + ", Age: " + age);
            }
            case Customer(var name, var age, var country) -> {
                System.out.println("Name: " + name + ", Age: " + age + ", Country: " + country);
            }
            case String message -> System.out.println("Message: " + message);
            default -> System.out.println("Default");
        }
    }

    record Dev(String name, int age) {
    }

    record Customer(String name, int age, String country) {
    }
}
