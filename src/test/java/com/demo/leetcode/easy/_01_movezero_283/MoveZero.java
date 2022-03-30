package com.demo.leetcode.easy._01_movezero_283;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [283. Move Zeroes - EASY](https://leetcode.com/problems/move-zeroes/)
 *
 * - swap
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=aayNRwUN3Do&ab_channel=NeetCode
 */
public class MoveZero {

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Time: O(n)
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}
