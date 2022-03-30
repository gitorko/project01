package com.demo.basics.concurrency._11_locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [ReentrantLock - MEDIUM]()
 *
 * - lock
 */
public class ReentrantLockTest {

    @SneakyThrows
    @Test
    public void test() {
        Lock lock = new ReentrantLock();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    // lock.tryLock(10, TimeUnit.SECONDS)
                    // lock.tryLock()
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " acquired lock");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " releasing lock");
                    lock.unlock();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
