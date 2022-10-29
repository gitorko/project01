package com.demo.leetcode.medium._01_minmaxarray_2439;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2439. Minimize Maximum of Array - MEDIUM](https://leetcode.com/problems/minimize-maximum-of-array/)
 *
 * https://www.youtube.com/watch?v=AeHMvcKuR0Y&ab_channel=NeetCodeIO
 */
public class MinMaxArray {

    @Test
    public void test1() {
        int[] nums = {3, 7, 1, 6};
        Assertions.assertEquals(5, minimizeArrayValue(nums));
    }

    @Test
    public void test2() {
        int[] nums = {13, 13, 20, 0, 8, 9, 9};
        Assertions.assertEquals(16, minimizeArrayValue(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minimizeArrayValue(int[] nums) {
        long sum = nums[0];
        double result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, Math.ceil((double) sum / (double) (i + 1)));
        }
        return (int) result;
    }

}
