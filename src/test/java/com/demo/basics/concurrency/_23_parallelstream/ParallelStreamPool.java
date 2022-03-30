package com.demo.basics.concurrency._23_parallelstream;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Parallel Stream - MEDIUM]()
 *
 * - fork join
 */
public class ParallelStreamPool {

    @SneakyThrows
    @Test
    public void test() {

        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=10
        int CPU_CORE = 4;
        List<Long> aList = LongStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        // parallel stream with map reduce on custom thread pool.
        ForkJoinPool forkJoinPool = new ForkJoinPool(CPU_CORE);
        long actualTotal = forkJoinPool.submit(() -> aList.parallelStream().reduce(0L, Long::sum)).get();
        System.out.println("actualTotal : " + actualTotal);

        // No return value.
        forkJoinPool.submit(() -> aList.parallelStream().forEach(e -> {
            System.out.println(e);
        })).get();
        System.out.println("Completed!");
    }

}
