package com.demo.leetcode.medium._01_arraynotavgneighbour_1968;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1968. Array With Elements Not Equal to Average of Neighbors - MEDIUM](https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/)
 *
 * - wiggle Sort
 * - SIMILAR_TO: [280. Wiggle Sort - MEDIUM](https://leetcode.com/problems/wiggle-sort/)
 *
 * https://www.youtube.com/watch?v=Wmb3YdVYfqM&ab_channel=NeetCode
 */
public class ArrayNotAvgNeighbour {

    @Test
    public void test() {
        int[] nums = {5, 2, 3, 4, 1};
        int[] expected = {5, 2, 4, 1, 3};
        Assertions.assertArrayEquals(expected, rearrangeArray(nums));
    }

    /**
     * Time: O(n)
     * increasing a < b < c or decreasing, a > b > c pattern must be avoided.
     * The average of a and c where a < b < c will be between a and c and hence remove this possibility.
     */
    public int[] rearrangeArray(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) || (nums[i - 1] > nums[i] && nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
        return nums;
    }

    /**
     * Time: O(n log(n))
     * All integers is distinct, use this condition.
     * Sort and swap neighbours into small, big, small, big pattern
     */
    public int[] rearrangeArray2(int[] nums) {
        Arrays.sort(nums);
        //increment by +2
        for (int i = 1; i < nums.length; i += 2) {
            swap(nums, i, i - 1);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
