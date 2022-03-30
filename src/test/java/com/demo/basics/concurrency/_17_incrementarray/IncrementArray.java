package com.demo.basics.concurrency._17_incrementarray;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import org.junit.jupiter.api.Test;

/**
 * [Increment Array - MEDIUM]()
 *
 * - fork join
 */
public class IncrementArray {

    @Test
    public void test() {
        long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IncrementTask incrementTask = new IncrementTask(array, 0, 9);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(incrementTask);
        System.out.println("array = " + Arrays.toString(array));

        Arrays.parallelSetAll(array, x -> array[x] + 1);
        System.out.println("array = " + Arrays.toString(array));
    }

    class IncrementTask extends RecursiveAction {
        int THRESHOLD = 100;
        long[] array;
        int lo, hi;

        IncrementTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        protected void compute() {
            if (hi - lo < THRESHOLD) {
                for (int i = lo; i < hi; ++i)
                    array[i]++;
            } else {
                int mid = (lo + hi) / 2;
                invokeAll(new IncrementTask(array, lo, mid), new IncrementTask(array, mid, hi));
            }
        }

    }
}


