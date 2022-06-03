package com.demo.basics.puzzle._006_datatype;

import org.junit.jupiter.api.Test;

public class DataTypePuzzle {

    @Test
    public void test1() {
        String name1 = "Jack";
        String name2 = new String("Jack");
        System.out.println(name1 == name2);
        System.out.println(name2.equals(name1));
    }

    @Test
    public void test2() {
        long num1 = 5l;
        Long num2 = Long.valueOf(5);
        System.out.println(num1 == num2);
        System.out.println(num2.equals(num1));
    }

    @Test
    public void test3() {
        String name1 = new String("Jack");
        String name2 = name1.intern();
        System.out.println(name1 == name2);
        System.out.println(name2.equals(name1));
    }

}
