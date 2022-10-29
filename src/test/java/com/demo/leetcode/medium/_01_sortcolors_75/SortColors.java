package com.demo.leetcode.medium._01_sortcolors_75;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [75. Sort Colors - MEDIUM](https://leetcode.com/problems/sort-colors/)
 *
 * - bucket sort - two pass
 * - quick sort - one pass
 * - Dutch National Flag Problem
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=4xbWSRZHqac&ab_channel=NeetCode
 */
public class SortColors {

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void test2() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        sortColors2(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Quick sort
     * Time: O(n)
     * Space: O(1)
     * one pass
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, right);
                //dont update index
                right--;
            } else {
                index++;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Bucket sort
     * Time: O(n)
     * Space: O(1)
     *
     * 2 pass
     */
    public void sortColors2(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            if (nums[i] == 1) count1++;
            if (nums[i] == 2) count2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
                count2--;
            }
        }
    }
}
