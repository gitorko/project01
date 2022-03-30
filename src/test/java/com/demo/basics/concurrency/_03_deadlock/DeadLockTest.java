package com.demo.basics.concurrency._03_deadlock;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Create Dead Lock - MEDIUM]()
 *
 * - waiting for each other
 */
public class DeadLockTest {

    @SneakyThrows
    @Test
    public void test() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            //createDeadLock();
        });
    }

    Object bowl = new Object();
    Object spoon = new Object();

    public void createDeadLock() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(2);
        executor.execute(() -> {
            synchronized (spoon) {
                System.out.println("Cook1: Holding Spoon!");
                System.out.println("Cook1: Waiting for Bowl!");
                synchronized (bowl) {
                    System.out.println("Cook1: Holding Bowl & Spoon!");
                    latch.countDown();
                }
            }
        });
        executor.execute(() -> {
            synchronized (bowl) {
                System.out.println("Cook2: Holding Bowl!");
                System.out.println("Cook2: Waiting for Spoon!");
                synchronized (spoon) {
                    System.out.println("Cook1: Holding Bowl & Spoon!");
                    latch.countDown();
                }
            }
        });
        latch.await();
    }
}
