package com.demo.basics.puzzle._009_counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class CounterPuzzle {

    @Test
    public void test() throws InterruptedException {
        Job job = new Job();
        job.runJob();
        System.out.println(job.counter);
    }

    class Job {
        long counter = 0l;

        public void runJob() throws InterruptedException {
            ExecutorService executor = Executors.newCachedThreadPool();
            List<Callable<Void>> tasks = new ArrayList<>();
            for (int i = 0; i < 250; i++) {
                tasks.add(() -> {
                    counter = counter + 1;
                    return null;
                });
            }
            executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
            executor.shutdown();
        }
    }
}
