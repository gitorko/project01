package com.demo.basics.concurrency._02_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Callable - EASY]()
 *
 * - Runnable‘s single method does not throw an exception and does not return value.
 * - Callable interface may be more convenient, as it allows to throw an exception and return a value.
 */
public class CallableTest {

    @SneakyThrows
    @Test
    public void test() {
        List<Future<String>> futureLst = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            System.out.println("Submitting Job: " + i);
            Future<String> future = executor.submit(new ProcessingJob(i));
            futureLst.add(future);
        }
        // Blocking nature
        for (Future<String> future : futureLst) {
            System.out.println(future.get() + " " + future.isDone());
        }
        executor.shutdown();
    }

    class ProcessingJob implements Callable<String> {
        int index;

        public ProcessingJob(int index) {
            this.index = index;
        }

        @Override
        public String call() throws Exception {
            //TimeUnit.SECONDS.sleep(10);
            return "Completed Job: " + index;
        }
    }

}


