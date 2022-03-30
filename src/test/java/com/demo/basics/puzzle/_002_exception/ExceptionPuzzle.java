package com.demo.basics.puzzle._002_exception;

import org.junit.jupiter.api.Test;

public class ExceptionPuzzle {

    @Test
    public void test() {
        String name = getName();
        System.out.println(name);
    }

    private String getName() {
        try {
            throw new Exception("ERROR");
        } finally {
            return "OK";
        }
    }
}
