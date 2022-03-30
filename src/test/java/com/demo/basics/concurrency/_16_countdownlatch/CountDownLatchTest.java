package com.demo.basics.concurrency._16_countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

/**
 * [Count Down Latch - EASY]()
 *
 * - count down latch
 */
public class CountDownLatchTest {

    @Test
    public void test() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(2);
        executor.execute(() -> {
            System.out.println("Job1");
            latch.countDown();
        });
        executor.execute(() -> {
            System.out.println("Job2");
            latch.countDown();
        });
        latch.await();
    }
}
