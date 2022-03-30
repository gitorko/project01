package com.demo.basics.java._17_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class ComparableDemo {

    @Test
    public void test() {
        List<Person> students = Arrays.asList(
                new Person(20, "Bob"),
                new Person(19, "Jane"),
                new Person(21, "Foo")
        );
        Collections.sort(students);
        System.out.println(students);

        students.stream().sorted().forEach(System.out::println);

        students.stream().sorted((e1, e2) -> {
            return e1.name.compareTo(e2.name);
        }).forEach(System.out::println);
    }

    @AllArgsConstructor
    @Data
    class Person implements Comparable<Person> {
        int age;
        String name;

        @Override
        public int compareTo(Person o) {
            return name.compareTo(o.getName());
        }
    }

}

