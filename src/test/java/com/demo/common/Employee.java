package com.demo.common;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    public String name;
    public Integer age;
    private String city;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Employee o) {
        return o.age.compareTo(this.age) + o.name.compareTo(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static class EmployeeAgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o2, Employee o1) {
            if (o1.name.compareTo(o2.name) == 0) {
                if (o1.age.compareTo(o2.age) == 0) {
                    return 0;
                } else {
                    return o1.age.compareTo(o2.age);
                }
            } else {
                return o1.name.compareTo(o2.name);
            }
        }

    }

}
