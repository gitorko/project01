package com.demo.leetcode.medium._01_arraynondecreasing_665;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [665. Non-decreasing Array - MEDIUM](https://leetcode.com/problems/non-decreasing-array/)
 *
 * - greedy, violation
 * - strategy is to lower a[i-1] to match a[i] if possible if a[i-2] not exist;
 * - otherwise rise a[i] to match a[i-1]
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=6vU3PtS_oSw&ab_channel=AdityaMahajan
 */
public class NonDecreasingArray {

    @Test
    public void test() {
        int[] nums = {4, 2, 1};
        Assertions.assertFalse(checkPossibility(nums));
    }

    @Test
    public void test2() {
        int[] nums = {4, 2, 3};
        Assertions.assertTrue(checkPossibility(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 3, 4, 2, 8};
        Assertions.assertTrue(checkPossibility(nums));
    }

    @Test
    public void test4() {
        int[] nums = {1, 2, 4, 2, 8};
        Assertions.assertTrue(checkPossibility(nums));
    }

    @Test
    public void test5() {
        //only one violation visible, but cant fix
        int[] nums = {3, 4, 2, 3};
        Assertions.assertFalse(checkPossibility(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean checkPossibility(int[] nums) {
        int violation = 0;
        //start from 2nd element
        for (int i = 1; i < nums.length && violation <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                violation++;
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return violation <= 1;
    }
}
