package com.demo.leetcode.easy._01_shufflearray_1470;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1470. Shuffle the Array - EASY](https://leetcode.com/problems/shuffle-the-array)
 *
 * https://www.youtube.com/watch?v=IvIKD_EU8BY&ab_channel=NeetCodeIO
 */
public class ShuffleArray {

    @Test
    public void test() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] expected = {2, 3, 5, 4, 1, 7};
        int n = 3;
        Assertions.assertArrayEquals(expected, shuffle(nums, n));
    }

    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        //second half stores both values.
        for (int i = n; i < len; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }
        int index = 0;
        for (int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }
        return nums;
    }
}
