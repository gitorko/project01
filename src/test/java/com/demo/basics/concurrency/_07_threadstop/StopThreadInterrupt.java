package com.demo.basics.concurrency._07_threadstop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Stop Thread - EASY]()
 *
 * - Cant terminate a thread in java need to ask politely.
 */
public class StopThreadInterrupt {

    @SneakyThrows
    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> task1 = executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) { // important #1
                System.out.println("Hello world");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted!");
                    Thread.currentThread().interrupt(); // important #2
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        task1.cancel(true);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Complete!");
    }

}
