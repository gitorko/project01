package com.demo.basics.puzzle._004_hashcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ObjectPuzzleFix {

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
