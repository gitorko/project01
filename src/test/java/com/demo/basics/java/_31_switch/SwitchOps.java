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

    @Test
    void test2() {
        String input = "CASE1";
        switch (input) {
            case "CASE1" -> {
                System.out.println("Case1");
            }
            case "CASE2" -> {
                System.out.println("Case2");
            }
            default -> System.out.println("Default");
        }
    }

    @Test
    void test3() {
        Animal animal = new Dog();
        switch (animal) {
            case Dog dog -> {
                System.out.println("dog");
            }
            case Cat cat -> {
                System.out.println("cat");
            }
            default -> System.out.println("unknown");
        }
    }
}

interface Animal {
}

class Dog implements Animal {}
class Cat implements Animal {}
