package com.demo.basics.concurrency._15_cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Cyclic Barrier - MEDIUM]()
 *
 * - cyclic barrier
 */
public class CyclicBarrierTest {

    @SneakyThrows
    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> tasks = new ArrayList<>();
        CyclicBarrier cb = new CyclicBarrier(2);
        tasks.add(() -> {
            cb.await();
            System.out.println("Job1");
            return null;
        });
        tasks.add(() -> {
            cb.await();
            System.out.println("Job2");
            return null;
        });
        executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
    }
}
