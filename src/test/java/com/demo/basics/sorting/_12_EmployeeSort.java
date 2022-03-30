package com.demo.basics.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.demo.common.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Employee Search - EASY]()
 *
 * - comparator vs comparable
 */
public class _12_EmployeeSort {

    @Test
    public void test1() {
        List<Employee> empList = getSeedData();
        Collections.sort(empList, new EmployeeComparator());
        empList.forEach(e -> System.out.println(e));
        Assertions.assertEquals("Ana", empList.get(0).getName());
    }

    @Test
    public void test2() {
        List<Employee> empList = getSeedData();
        Collections.sort(empList);
        empList.forEach(e -> System.out.println(e));
        Assertions.assertEquals("Zac", empList.get(0).getName());
    }

    public List<Employee> getSeedData() {
        List<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee("Joe", 32));
        emplist.add(new Employee("Ana", 30));
        emplist.add(new Employee("Sam", 29));
        emplist.add(new Employee("Zac", 34));
        emplist.add(new Employee("Joe", 32));
        return emplist;
    }

    class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}


