package com.demo.basics.java._06_priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-hashcode
 * https://www.callicoder.com/java-priority-queue/
 */
public class PriorityQueueOps {

    /**
     * Default is min heap
     */
    @Test
    public void test_minHeap() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < 5; i++) {
            q.add(i);
        }
        Assertions.assertEquals(1, q.peek());
        Assertions.assertEquals(1, q.poll());
    }

    @Test
    public void test_minHeapComparator() {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 1; i < 5; i++) {
            q.add(i);
        }
        Assertions.assertEquals(1, q.peek());
        Assertions.assertEquals(1, q.poll());
    }

    /**
     * Max heap
     */
    @Test
    public void test_maxHeap() {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < 5; i++) {
            q.add(i);
        }
        Assertions.assertEquals(4, q.peek());
        Assertions.assertEquals(4, q.poll());
    }

    @Test
    public void test_maxHeapCompartor() {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 1; i < 5; i++) {
            q.add(i);
        }
        Assertions.assertEquals(4, q.peek());
        Assertions.assertEquals(4, q.poll());
    }

    @Test
    public void test3() {

        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);
        // Add items to a Priority Queue (ENQUEUE)
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }

        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();

        // Add items to the Priority Queue
        employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
        employeePriorityQueue.add(new Employee("Chris", 145000.00));
        employeePriorityQueue.add(new Employee("Andrea", 115000.00));
        employeePriorityQueue.add(new Employee("Jack", 167000.00));

        while (!employeePriorityQueue.isEmpty()) {
            System.out.println(employeePriorityQueue.remove());
        }
    }


    @Data
    @AllArgsConstructor
    class Employee implements Comparable<Employee> {

        private String name;
        private double salary;

        @Override
        public int compareTo(Employee employee) {
            if (this.getSalary() > employee.getSalary()) {
                return 1;
            } else if (this.getSalary() < employee.getSalary()) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Employee employee = (Employee) o;
            return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary);
        }

    }
}

