package com.demo.basics.sorting;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Radix sort - MEDIUM]()
 *
 * - Linear time algo.
 * - radix = base, decimal number radix is base 10. binary its 2.
 * - You need to know the number of digits
 * - Solve in 0th position, solve in 10th position, solve in 100th position.
 */
public class _08_RadixSort {

    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        radixSort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    /**
     * Time: Best case : O(nk)
     * Time: Average case : O(nk)
     * Time: Worst case : O(nk)
     */
    public void radixSort(int[] input) {
        final int RADIX = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }
}
