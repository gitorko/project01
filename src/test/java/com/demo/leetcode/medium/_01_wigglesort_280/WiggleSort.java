package com.demo.leetcode.medium._01_wigglesort_280;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [280. Wiggle Sort - MEDIUM](https://leetcode.com/problems/wiggle-sort/)
 *
 * - https://www.lintcode.com/problem/508/
 * - wiggle Sort
 * - start from 1, even odd
 * - SIMILAR_TO: [1968. Array With Elements Not Equal to Average of Neighbors - MEDIUM](https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/)
 *
 * https://www.youtube.com/watch?v=vGsyTE4s34w&ab_channel=NeetCode
 */
public class WiggleSort {

    @Test
    public void test() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] expected = {3, 5, 1, 6, 2, 4};
        wiggleSort(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public void wiggleSort(int[] nums) {
        // 1. if i is even, then nums[i - 1] < nums[i]
        // 2. if i is odd, then nums[i - 1] > nums[i]
        // skip the first element
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i - 1] < nums[i]) || (i % 2 == 1 && nums[i - 1] > nums[i])) {
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
