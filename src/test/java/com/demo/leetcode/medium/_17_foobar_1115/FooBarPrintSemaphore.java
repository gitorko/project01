package com.demo.leetcode.medium._17_foobar_1115;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [1115. Print FooBar Alternately - MEDIUM](https://leetcode.com/problems/print-foobar-alternately/)
 *
 * - Semaphore
 */
class FooBarPrintSemaphore {

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

        Semaphore fooSem;
        Semaphore barSem;
        CountDownLatch latch;

        public FooBar(int n) {
            this.n = n;
            this.fooSem = new Semaphore(1);
            this.barSem = new Semaphore(0);
            this.latch = new CountDownLatch(2);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            try {
                for (int i = 0; i < n; i++) {
                    fooSem.acquire();
                    printFoo.run();
                    barSem.release();
                }
            } finally {
                latch.countDown();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            try {
                for (int i = 0; i < n; i++) {
                    barSem.acquire();
                    printBar.run();
                    fooSem.release();
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
