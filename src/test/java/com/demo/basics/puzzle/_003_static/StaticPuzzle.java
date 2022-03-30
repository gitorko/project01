package com.demo.basics.puzzle._003_static;

import org.junit.jupiter.api.Test;

public class StaticPuzzle {

    @Test
    public void test() {
        Employee employee1 = new Employee("Dan", "ABC");
        Employee employee2 = new Employee("John", "DEF");
        System.out.println(employee1.getName() + ", " + employee1.getCompany());
        System.out.println(employee2.getName() + ", " + employee2.getCompany());
    }

}
class Employee {
    String name;
    static String company;

    public Employee(String name, String company) {
        this.name = name;
        Employee.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

}
