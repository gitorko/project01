package com.demo.basics.concurrency._21_threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Implement Custom Thread Pool - MEDIUM]()
 *
 * - custom thread pool
 */
public class CustomThreadPool {

    @SneakyThrows
    @Test
    public void test() {
        CountDownLatch latch = new CountDownLatch(10);
        MyCustomThreadPool executor = new MyCustomThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int jobId = i;
            executor.execute(() -> {
                System.out.println("Running Job " + jobId);
                latch.countDown();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
            });
        }
        latch.await();
    }

    class MyCustomThreadPool {

        private final Worker[] threads;
        private final LinkedBlockingQueue<Runnable> queue;

        MyCustomThreadPool(int nThreads) {
            queue = new LinkedBlockingQueue();
            threads = new Worker[nThreads];
            for (int i = 0; i < nThreads; i++) {
                threads[i] = new Worker();
                threads[i].start();
            }
        }

        //Producer
        public void execute(Runnable task) {
            synchronized (queue) {
                queue.add(task);
                queue.notify();
            }
        }

        class Worker extends Thread {
            public void run() {
                Runnable task;
                while (true) {
                    //Consumer
                    synchronized (queue) {
                        while (queue.isEmpty()) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                            }
                        }
                        task = queue.poll();
                    }
                    // If we don't catch RuntimeException,
                    // the pool could leak threads
                    try {
                        task.run();
                    } catch (RuntimeException e) {
                        System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                    }
                }
            }
        }
    }

}


