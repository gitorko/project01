package com.demo.basics.puzzle._007_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * Memory leak in java, key has to be immutable
 */
public class MapPuzzle {

    @Test
    public void test() {
        Map<Employee, Boolean> map = new HashMap<>();
        Employee e1 = new Employee("Jack", 25);
        map.put(e1, true);
        e1.name = "Rose";
        Employee e2 = new Employee("John", 28);
        map.put(e2, true);

        Employee john = new Employee("John", 28);
        Employee jack = new Employee("Rose", 25);
        Employee rose = new Employee("Jack", 25);

        System.out.println(map.size());
        System.out.println(map.get(john));
        System.out.println(map.get(jack));
        System.out.println(map.get(rose));
    }

    class Employee {
        public String name;
        public Integer age;

        public Employee(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return name.equals(employee.name) && age.equals(employee.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
