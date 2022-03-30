package com.demo.basics.concurrency._12_forkjoinpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Fork Join - MEDIUM]()
 *
 * - fork join
 */
public class ForkJoinTest {

    @SneakyThrows
    @Test
    public void test() {
        List<String> names = Arrays.asList("joe", "sam", "ray");
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.submit(() -> names.parallelStream().forEach(name -> {
            System.out.println(Thread.currentThread().getName() + " : processing : " + name);
        })).get();
    }
}
