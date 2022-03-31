package com.demo.basics.concurrency._18_phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Phaser - MEDIUM]()
 *
 * - phaser (does job of both CountDownLatch & CyclicBarrier)
 *
 * https://www.youtube.com/watch?v=J3QZ5gfCtAg&ab_channel=DefogTech
 */
public class PhaserTest {

    @SneakyThrows
    @Test
    public void test1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(2);
        executor.execute(() -> {
            System.out.println("Job1");
            ph.arrive();
        });
        executor.execute(() -> {
            System.out.println("Job2");
            ph.arrive();
        });
        ph.awaitAdvance(1);
        System.out.println("Done");

    }

    @SneakyThrows
    @Test
    public void test2() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(2);
        executor.execute(() -> {
            System.out.println("Job1");
            ph.arriveAndAwaitAdvance();
        });
        executor.execute(() -> {
            System.out.println("Job2");
            ph.arriveAndAwaitAdvance();
        });
        System.out.println("Done");

    }

    @SneakyThrows
    @Test
    public void test3() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Phaser ph = new Phaser();
        executor.execute(() -> {
            ph.register();
            System.out.println("Job1");
            ph.arrive();
        });
        executor.execute(() -> {
            ph.register();
            System.out.println("Job2");
            ph.arrive();
        });
        ph.arriveAndAwaitAdvance();
        System.out.println("Done");

    }
}
