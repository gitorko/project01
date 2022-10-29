package com.demo.basics.java._07_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StringOps {

    @Test
    public void test_reverseString() {
        StringBuilder sb = new StringBuilder("abcdef");
        System.out.println(sb.reverse());
    }

    @Test
    public void test_reverseString2() {
        StringBuilder sb = new StringBuilder("abcdef");
        System.out.println(sb.reverse());
    }

    @Test
    public void test_charToString() {
        char[] t = "fceadb".toCharArray();
        Arrays.sort(t);
        System.out.println(new String(t));
    }

    @Test
    public void test_tokenize() {
        List<String> result = Collections.list(new StringTokenizer("welcome|home|jack", "|")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void test_ops() {
        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println(" ABC ".strip());
        System.out.println(" ABC ".stripLeading());
        System.out.println(" ABC ".stripTrailing());
        System.out.println(" ABC ".trim());
        "line1\nline2\nline3\n".lines().forEach(System.out::println);
        System.out.println((String) "UPPER".transform(String::toLowerCase));
        System.out.println((String) "UPPER".transform(s -> s.substring(0, 2)));
        System.out.println("My name is %s, age is %d".formatted("Jack", 35));

    }

    @Test
    public void test_immutableList() {
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        List<String> immutableNames = List.copyOf(names);
        System.out.println(immutableNames);
    }

    @Test
    public void test_switchExpression() {
        String day = "SUNDAY";
        switch (day) {
            case "SUNDAY" -> {
                System.out.println("Holiday!");
            }
            default -> {
                System.out.println("Working!");
            }
        }
    }

    @Test
    public void test_textBlock() {
        String message = """
                This is a multiline 
                comment, each line
                is printed
                """;
        System.out.println(message);
    }


    @Test
    public void test_record() {
        record Customer(String name, Integer age) {
        }
        Customer customer = new Customer("Jack", 35);
        Customer customer1 = new Customer("Jack", 55);
        Customer customer2 = new Customer("Jack", 35);
        System.out.println(customer);
        System.out.println(customer.equals(customer1));
        System.out.println(customer.equals(customer2));
    }

    @Test
    public void test_compactConstructor() {
        record Customer(String name, Integer age) {
            Customer {
                if (name == null) {
                    throw new RuntimeException("Not allowed!");
                }
            }
        }
        Customer customer = new Customer("Jack", 35);
        Customer customer1 = new Customer("Jack", 55);
        Customer customer2 = new Customer("Jack", 35);
        System.out.println(customer);
        System.out.println(customer.equals(customer1));
        System.out.println(customer.equals(customer2));
    }

}

