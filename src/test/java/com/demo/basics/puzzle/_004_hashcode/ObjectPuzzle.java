package com.demo.basics.puzzle._004_hashcode;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ObjectPuzzle {

    @Test
    public void test() {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("Jack", 34);
        Person p2 = new Person("Jack", 34);
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());
    }

    class Person {
        public String name;
        public Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
