package com.demo.leetcode.medium._17_foobar_1115;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [1115. Print FooBar Alternately - MEDIUM](https://leetcode.com/problems/print-foobar-alternately/)
 *
 * - wait notify
 */
class FooBarLockWaitNotify {

    @SneakyThrows
    @Test
    public void test() {
        FooBar obj = new FooBar(4);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            try {
                obj.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                obj.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        obj.latch.await();
    }

    class FooBar {
        private int n;
        CountDownLatch latch;
        boolean fooTurn = true;

        public FooBar(int n) {
            this.n = n;
            this.latch = new CountDownLatch(2);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (!fooTurn) {
                        this.wait();
                    }
                    printFoo.run();
                    fooTurn = !fooTurn;
                    this.notifyAll();
                }
            }
            latch.countDown();
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (fooTurn) {
                        this.wait();
                    }
                    printBar.run();
                    fooTurn = !fooTurn;
                    this.notifyAll();
                }
            }
            latch.countDown();
        }
    }
}
