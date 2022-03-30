package com.demo.basics.concurrency._05_semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Semaphore - MEDIUM]()
 *
 * - permits
 */
public class SemaphoreTest {

    @SneakyThrows
    @Test
    public void test1() {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Requesting!");
                semaphore.acquireUninterruptibly();
                System.out.println(Thread.currentThread().getName() + " Acquired!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Released!");
                semaphore.release();
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    @SneakyThrows
    @Test
    public void test2() {
        Semaphore permit = new Semaphore(1);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> tasks = new ArrayList<>();
        tasks.add(() -> {
            permit.acquire();
            System.out.println("Job1");
            permit.release();
            return null;
        });
        tasks.add(() -> {
            permit.acquire();
            System.out.println("Job2");
            permit.release();
            return null;
        });
        System.out.println(permit.availablePermits());
        executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
    }

}


