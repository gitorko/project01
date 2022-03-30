package com.demo.leetcode.medium._03_twosum2_167;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [167. Two Sum II - Input Array Is Sorted - MEDIUM](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
 *
 * - two pointer
 *
 * https://www.youtube.com/watch?v=cQ1Oz4ckceM&ab_channel=NeetCode
 */
public class PairSumSorted {

    @Test
    public void test_pairExists() {
        int[] intArray = new int[]{2, 7, 11, 15};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, twoSum(intArray, 9));
    }

    @Test
    public void test_pairDoesntExist() {
        int[] intArray = new int[]{2, 7, 11, 15};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, twoSum(intArray, 10));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                break;
            else if (numbers[left] + numbers[right] > target)
                right--;
            else
                left++;
        }
        if (left == right) {
            //if both are equal then there is no pair hence return -1
            return new int[]{-1, -1};
        }
        return new int[]{left + 1, right + 1};
    }

}
