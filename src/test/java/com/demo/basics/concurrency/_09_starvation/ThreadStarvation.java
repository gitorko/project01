package com.demo.basics.concurrency._09_starvation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Thread Starvation - EASY]()
 *
 * - long running vs slow running
 */
public class ThreadStarvation {

    @SneakyThrows
    @Test
    public void test() {
        MyJob job = new MyJob();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> {
            job.longRunningTask();
        });
        pool.submit(() -> {
            job.longRunningTask();
        });
        pool.submit(() -> {
            job.slowRunningTask();
        });
        pool.submit(() -> {
            job.slowRunningTask();
        });
        pool.submit(() -> {
            job.slowRunningTask();
        });
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }

    /**
     * https://www.javacodemonk.com/explain-the-threading-jargon-in-java-18e8973c
     */
    class MyJob {

        @SneakyThrows
        public void longRunningTask() {
            System.out.println(Thread.currentThread().getName() + " longRunningTask started");
            TimeUnit.SECONDS.sleep(15);
            System.out.println(Thread.currentThread().getName() + " longRunningTask completed");
        }

        @SneakyThrows
        public void slowRunningTask() {
            System.out.println(Thread.currentThread().getName() + " slowRunningTask started");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + " slowRunningTask completed");
        }
    }
}


