package com.demo.basics.designpatterns._01_singleton;

import org.junit.jupiter.api.Test;

public class ThreadSafeSingletonDoubleCheckLock {

    private static ThreadSafeSingletonDoubleCheckLock instance;

    private ThreadSafeSingletonDoubleCheckLock() {
    }

    @Test
    public void test() {
        System.out.println(ThreadSafeSingletonDoubleCheckLock.getInstance().hello());
    }

    public static ThreadSafeSingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDoubleCheckLock.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleCheckLock();
                }
            }

        }
        return instance;
    }

    public String hello() {
        return ("Hello from ThreadSafeSingleton!");
    }
}