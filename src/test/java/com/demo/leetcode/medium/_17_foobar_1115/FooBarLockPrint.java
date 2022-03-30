package com.demo.leetcode.medium._17_foobar_1115;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [1115. Print FooBar Alternately - MEDIUM](https://leetcode.com/problems/print-foobar-alternately/)
 *
 * - ReentrantLock
 */
class FooBarLockPrint {

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

        ReentrantLock lock;
        Condition fooCondition;
        Condition barCondition;
        CountDownLatch latch;
        boolean fooTurn = true;

        public FooBar(int n) {
            this.n = n;
            this.lock = new ReentrantLock();
            this.fooCondition = lock.newCondition();
            this.barCondition = lock.newCondition();
            this.latch = new CountDownLatch(2);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                while (!fooTurn) {
                    fooCondition.await();
                }
                printFoo.run();
                fooTurn = !fooTurn;
                barCondition.signalAll();
                lock.unlock();
            }
            latch.countDown();
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                while (fooTurn) {
                    barCondition.await();
                }
                printBar.run();
                fooTurn = !fooTurn;
                fooCondition.signalAll();
                lock.unlock();
            }
            latch.countDown();
        }
    }
}
