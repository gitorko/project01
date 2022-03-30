package com.demo.leetcode.medium._05_maxconsecutiveone3_1004;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1004. Max Consecutive Ones III - MEDIUM](https://leetcode.com/problems/max-consecutive-ones-iii/)
 *
 * - sliding window, zeroCount
 * - find the longest subarray with at most k zeros
 *
 * PRACTICE
 */
public class MaxOneFlipK {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        Assertions.assertEquals(6, longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;
            // Case nums[left, right] contains more than k zeros, move `left` util the subarray has no more than k zeros
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
