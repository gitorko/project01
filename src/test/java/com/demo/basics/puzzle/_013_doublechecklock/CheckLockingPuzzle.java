package com.demo.basics.puzzle._013_doublechecklock;

import org.junit.jupiter.api.Test;

public class CheckLockingPuzzle {

    @Test
    public void test() {
        CheckLockingPuzzle.getInstance().greet();
    }

    private static volatile CheckLockingPuzzle instance;

    private CheckLockingPuzzle() {
    }

    private static CheckLockingPuzzle getInstance() {
        synchronized (CheckLockingPuzzle.class) {
            if (instance == null) {
                instance = new CheckLockingPuzzle();
            }
        }
        return instance;
    }

    public void greet() {
        System.out.println("Hello World!");
    }
}
