package com.demo.basics.concurrency._07_threadstop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Stop Thread - EASY]()
 *
 * - volatile
 */
public class StopThreadVolatile {

    volatile boolean keepRunning = true;
    //Can also use AtomicBoolean

    @SneakyThrows
    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            while (keepRunning) {
                try {
                    System.out.println("Hello World!");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
            System.out.println("Ending job!");
        });
        TimeUnit.SECONDS.sleep(2);
        keepRunning = false;
        TimeUnit.SECONDS.sleep(2);
    }

}


