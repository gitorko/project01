package com.demo.leetcode.easy._04_maxsumknegation_1005;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1005. Maximize Sum Of Array After K Negations - EASY](https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/)
 *
 *  - sort the array and change the lowest number to negative k times. Time: O(n*log(n))
 *  - heap (priority queue) - Time: O(n)
 *  - array can contain negative numbers.
 */
public class MaxSumKNegation {

    @Test
    public void test() {
        int arr[] = {4, 2, 3};
        Assertions.assertEquals(5, largestSumAfterKNegationsQueue(arr, 1));
        Assertions.assertEquals(5, largestSumAfterKNegations(arr, 1));

        int arr2[] = {3, -1, 0, 2};
        Assertions.assertEquals(6, largestSumAfterKNegationsQueue(arr2, 3));
        Assertions.assertEquals(6, largestSumAfterKNegations(arr2, 3));

        int arr3[] = {2, -3, -1, 5, -4};
        Assertions.assertEquals(13, largestSumAfterKNegationsQueue(arr3, 2));
        Assertions.assertEquals(13, largestSumAfterKNegations(arr3, 2));

    }

    /**
     * Approach 1:
     * Heap (Priority Queue)
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int largestSumAfterKNegationsQueue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)
            pq.add(num);

        //for k times fetch the smallest element and add it back with negative.
        while (k-- > 0) {
            pq.add(-pq.poll());
        }
        return pq.stream().reduce(0, Integer::sum);
    }

    /**
     * 1. sort the numbers in ascending order
     * 2. flip all the negative numbers, as long as k > 0
     * 3. find the sum
     *
     * Time: O(n*log(n)) for sorting.
     * Space: O(1) no extra space
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minIndex = 0;
        while (k > 0) {
            nums[minIndex] *= -1;
            k--;
            //After flipping a negative number to negative it becomes positive & the smallest element changes.
            //Hence use min index to determine new small element.
            //Ensure minIndex doesnt go beyond boundary.
            if (minIndex + 1 < nums.length && nums[minIndex] > nums[minIndex + 1]) minIndex++;
        }
        return Arrays.stream(nums).sum();
    }
}
