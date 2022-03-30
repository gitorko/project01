package com.demo.basics.concurrency._18_phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Phaser - MEDIUM]()
 *
 * - phaser
 *
 * https://www.youtube.com/watch?v=J3QZ5gfCtAg&ab_channel=DefogTech
 */
public class PhaserTest {

    @SneakyThrows
    @Test
    public void test() {
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
}
