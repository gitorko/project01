package com.demo.leetcode.medium._04_sortksortedarray;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Sort K sorted array - MEDIUM](https://www.geeksforgeeks.org/nearly-sorted-algorithm/)
 *
 * - heap
 * - sort K sorted array
 *
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&ab_channel=AdityaVerma
 * https://www.youtube.com/watch?v=tJK7vjNKdLY&ab_channel=TECHDOSE
 */
public class SortKSortedArray {

    @Test
    public void test() {
        List<Integer> nums = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        sortKSortedArray(nums, 2);
        Assertions.assertEquals(expected, nums);
    }

    /**
     * Time: O(n*log(k))
     */
    public void sortKSortedArray(List<Integer> nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.subList(0, k + 1));
        int index = 0;
        // do for remaining elements in the array
        for (int i = k + 1; i < nums.size(); i++) {
            nums.set(index++, pq.poll());
            pq.add(nums.get(i));
        }
        while (!pq.isEmpty()) {
            nums.set(index++, pq.poll());
        }
    }
}
