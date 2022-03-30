package com.demo.basics.concurrency._10_threadabort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Thread Abort Policy - EASY]()
 *
 * - policy when queue is full
 */
public class ThreadAbortPolicy {

    @Test
    public void test_timeout() {
        assertThrows(RejectedExecutionException.class, () -> {
            runJob();
        });
    }

    @SneakyThrows
    public void runJob() {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++) {
            int jobId = i;
            executor.execute(() -> {
                System.out.println("Executing job: " + jobId);
                while (true) {
                    //never return
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
    }
}
