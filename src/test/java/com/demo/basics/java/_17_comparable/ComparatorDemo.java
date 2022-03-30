package com.demo.basics.java._17_comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class ComparatorDemo {

    @Test
    public void test() {
        List<Person> students = Arrays.asList(
                new Person(20, "Bob"),
                new Person(19, "Jane"),
                new Person(21, "Foo")
        );
        Collections.sort(students, new AgeComparator());
        System.out.println(students);

        students.stream()
                .sorted(Comparator
                        .comparing(Person::getName)
                        .thenComparing(Person::getAge)
                ).forEach(System.out::println);

        students.sort(Comparator.comparing(Person::getName));
    }

    class NameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    class AgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return ((Integer) o1.age).compareTo(o2.age);
        }
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


