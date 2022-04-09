package com.demo.basics.concurrency._01_addaccumulate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Long Adder & Long Accumulator - MEDIUM]()
 *
 * - lock-free and still remain thread-safe
 */
public class LongAccumulatorTest {

    /**
     * https://www.baeldung.com/java-longadder-and-longaccumulator
     */
    @SneakyThrows
    @Test
    public void test() {
        LongAdder counter = new LongAdder();
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0l);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                counter.increment();
                accumulator.accumulate(5);
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        Assertions.assertEquals(10, counter.sum());
        Assertions.assertEquals(50, accumulator.get());
    }

}
