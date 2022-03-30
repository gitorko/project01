package com.demo.basics.puzzle._011_instanceclasslock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * https://www.callicoder.com/java-concurrency-multithreading-basics/
 * Instance lock vs class lock
 */
public class InstanceClassLockPuzzle {

    @Test
    public void test() throws InterruptedException {
        Greet greet = new Greet();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            greet.task1();
        });
        TimeUnit.SECONDS.sleep(2);
        executor.execute(() -> {
            greet.task2();
        });
        executor.execute(() -> {
            greet.task2();
        });
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    class Greet {

        public void task1() {
            synchronized (Greet.class) {
                System.out.println("task1 class lock acquired!");
                while (true) ;
            }
        }

        public void task2() {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " task2 instance lock acquired!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " task2 completed");
            }
        }
    }
}


