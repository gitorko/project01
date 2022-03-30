package com.demo.leetcode.easy._17_printorder_1114;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [1114. Print in Order - EASY](https://leetcode.com/problems/print-in-order/)
 *
 * - semaphore
 */
public class PrintInOrder {

    @SneakyThrows
    @Test
    public void test() {
        MyPrintOrder po = new MyPrintOrder();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            try {
                po.first(() -> {
                    System.out.println(Thread.currentThread() + " first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                po.second(() -> {
                    System.out.println(Thread.currentThread() + " second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                po.third(() -> {
                    System.out.println(Thread.currentThread() + " third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    class MyPrintOrder {
        Semaphore sem1;
        Semaphore sem2;

        public MyPrintOrder() {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);
            try {
                sem1.acquire();
                sem2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            sem1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sem1.acquire();
            sem1.release();
            printSecond.run();
            sem2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sem2.acquire();
            sem2.release();
            printThird.run();
        }
    }

}
