package com.demo.basics.concurrency._06_scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [ScheduledExecutorService - MEDIUM]()
 *
 * - schedule job
 */
public class ScheduledExecutorTest {

    @SneakyThrows
    @Test
    public void test() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.schedule(() -> {
            System.out.println("Task1 after 1 second");
        }, 1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Task2 every 2 seconds ");
        }, 0, 2, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(() -> {
            System.out.println("Task3 every 3 seconds ");
        }, 0, 3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(5);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Complete!");
    }
}
