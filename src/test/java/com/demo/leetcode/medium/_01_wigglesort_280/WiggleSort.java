package com.demo.leetcode.medium._01_wigglesort_280;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [280. Wiggle Sort - MEDIUM](https://leetcode.com/problems/wiggle-sort/)
 * https://www.lintcode.com/problem/508/
 *
 * - wiggle Sort
 * - SIMILAR_TO: [1968. Array With Elements Not Equal to Average of Neighbors - MEDIUM](https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/)
 *
 * https://www.youtube.com/watch?v=Wmb3YdVYfqM&ab_channel=NeetCode
 */
public class WiggleSort {

    @Test
    public void test() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] expected = {1, 6, 2, 5, 3, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public void wiggleSort(int[] nums) {
        // 1. if i is even, then nums[i] <= nums[i - 1]
        // 2. if i is odd, then nums[i] >= nums[i - 1]
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
