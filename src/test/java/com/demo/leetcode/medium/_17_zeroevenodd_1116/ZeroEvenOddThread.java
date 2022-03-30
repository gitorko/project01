package com.demo.leetcode.medium._17_zeroevenodd_1116;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [1116. Print Zero Even Odd - MEDIUM](https://leetcode.com/problems/print-zero-even-odd/)
 *
 * - semaphore
 */
class ZeroEvenOddThread {

    @SneakyThrows
    @Test
    public void test() {
        ZeroEvenOdd obj = new ZeroEvenOdd(5);
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            try {
                obj.zero(a -> System.out.println(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                obj.even(a -> System.out.println(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                obj.odd(a -> System.out.println(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        obj.latch.await();
    }

    class ZeroEvenOdd {

        int n;
        Semaphore signalZero;
        Semaphore signalEven;
        Semaphore signalOdd;
        CountDownLatch latch;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.signalZero = new Semaphore(1);
            this.signalEven = new Semaphore(0);
            this.signalOdd = new Semaphore(0);
            this.latch = new CountDownLatch(3);
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                signalZero.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    signalOdd.release();
                } else {
                    signalEven.release();
                }
            }
            latch.countDown();
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                signalEven.acquire();
                printNumber.accept(i);
                signalZero.release();
            }
            latch.countDown();
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                signalOdd.acquire();
                printNumber.accept(i);
                signalZero.release();
            }
            latch.countDown();
        }
    }

}
