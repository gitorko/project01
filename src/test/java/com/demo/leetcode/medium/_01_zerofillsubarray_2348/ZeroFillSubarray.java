package com.demo.leetcode.medium._01_zerofillsubarray_2348;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2348. Number of Zero-Filled Subarrays - MEDIUM](https://leetcode.com/problems/number-of-zero-filled-subarrays/description/)
 *
 * https://www.youtube.com/watch?v=G-EWVGCcL_w&ab_channel=NeetCodeIO
 */
public class ZeroFillSubarray {

    @Test
    public void test() {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        Assertions.assertEquals(6, zeroFilledSubarray(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long startCount = 0;
        for (int n : nums) {
            if (n == 0) {
                result += ++startCount;
            } else {
                startCount = 0;
            }
        }
        return result;
    }
}
