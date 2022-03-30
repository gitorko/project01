package com.demo.basics.puzzle._013_doublechecklock;

import org.junit.jupiter.api.Test;

public class CheckLockingPuzzleFix {

    @Test
    public void test() {
        CheckLockingPuzzleFix.getInstance().greet();
    }

    private static volatile CheckLockingPuzzleFix instance;

    private CheckLockingPuzzleFix() {
    }

    private static CheckLockingPuzzleFix getInstance() {
        if (instance == null) {
            synchronized (CheckLockingPuzzleFix.class) {
                if (instance == null) {
                    instance = new CheckLockingPuzzleFix();
                }
            }
        }
        return instance;
    }

    public void greet() {
        System.out.println("Hello World!");
    }
}
