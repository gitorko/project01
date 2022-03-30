package com.demo.basics.puzzle._001_passbyvalue;

import org.junit.jupiter.api.Test;

public class PassByPuzzle {

    @Test
    public void test() {
        Employee emp = new Employee("Dan");
        modify1(emp);
        System.out.println(emp.name);
        modify2(emp);
        System.out.println(emp.name);
    }

    private void modify1(Employee emp) {
        emp = new Employee("John");
    }

    private void modify2(Employee emp) {
        emp.name = "Jack";
    }

    class Employee {
        String name;

        public Employee(String name) {
            this.name = name;
        }
    }
}
