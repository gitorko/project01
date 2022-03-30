package com.demo.basics.concurrency._22_semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Implement Custom Semaphore - MEDIUM]()
 *
 * - custom semaphore
 */
public class CustomSemaphore {

    @SneakyThrows
    @Test
    public void test() {
        MyCustomSemaphore semaphore = new MyCustomSemaphore(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " Starting");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " Running");
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " Released");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    class MyCustomSemaphore {
        private final Object monitor = new Object();
        private int permits;

        MyCustomSemaphore(int initialPermits) {
            synchronized (monitor) {
                permits = initialPermits;
            }
        }

        /**
         * Blocks until permitsAvailable (permit > 0)
         */
        public void acquire() throws InterruptedException {
            synchronized (monitor) {
                while (permits <= 0)
                    monitor.wait();
                --permits;
            }
        }

        /**
         * Release a single permit and notifies threads waiting on permitsAvailable Condition
         */
        public void release() {
            synchronized (monitor) {
                ++permits;
                monitor.notifyAll();
            }
        }
    }

}
