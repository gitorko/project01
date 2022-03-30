package com.demo.basics.puzzle._003_static;

import org.junit.jupiter.api.Test;

public class StaticPuzzle {
    @Test
    public void test() {
        Student student = new Student("Dan");
        Student.reset1(student);
        System.out.println(student.getName());
        student.reset2(student);
        System.out.println(student.getName());
    }

}
class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void reset2(Student student) {
        student = new Student("NO_NAME");
    }

    public static void reset1(Student student) {
        student = new Student("NO_NAME");
    }
}
