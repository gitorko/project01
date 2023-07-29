package com.demo.leetcode.medium._05_twosum2_167;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [167. Two Sum II - Input Array Is Sorted - MEDIUM](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
 *
 * - two pointer
 * - SIMILAR_TO: [1. Two Sum - EASY](https://leetcode.com/problems/two-sum/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=cQ1Oz4ckceM&ab_channel=NeetCode
 */
public class TwoSumSorted {

    @Test
    public void test_pairExists() {
        int[] intArray = new int[]{2, 7, 11, 15};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, twoSum(intArray, 9));
    }

    @Test
    public void test_pairDoesntExist() {
        int[] intArray = new int[]{2, 7, 11, 15};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, twoSum(intArray, 10));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

}
