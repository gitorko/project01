package com.demo.leetcode.medium._01_nextpermutation_31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [31. Next Permutation - MEDIUM](https://leetcode.com/problems/next-permutation/)
 *
 * - 3 steps find the peak, swap, reverse
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=IhsUbEMfIbY&ab_channel=AlgorithmsMadeEasy
 */
public class NextPermutation {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 3, 2};
        nextPermutation(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // from back to front, find the first num < nums[i + 1]
        int i;
        for (i = n - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1])
                break;

        // from back to front, find the first num > nums[i], swap it with nums[i]
        if (i >= 0) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        // reverse nums[i + 1..n - 1]
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r)
            swap(nums, l++, r--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
