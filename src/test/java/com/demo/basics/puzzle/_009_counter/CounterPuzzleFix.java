package com.demo.basics.puzzle._009_counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.Test;

/**
 * https://medium.com/@tarunjain07/volatile-reentrant-lock-vs-synchronize-condition-variable-66e870a8434d
 */
public class CounterPuzzleFix {

    @Test
    public void test() throws InterruptedException {
        Job job = new Job();
        job.runJob();
        System.out.println(job.counter);
    }

    class Job {
        AtomicLong counter = new AtomicLong(0);

        public void runJob() throws InterruptedException {
            ExecutorService executor = Executors.newCachedThreadPool();
            List<Callable<Void>> tasks = new ArrayList<>();
            for (int i = 0; i < 250; i++) {
                tasks.add(() -> {
                    counter.incrementAndGet();
                    return null;
                });
            }
            executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
            executor.shutdown();
        }
    }
}
