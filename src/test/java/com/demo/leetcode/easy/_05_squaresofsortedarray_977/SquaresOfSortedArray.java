package com.demo.leetcode.easy._05_squaresofsortedarray_977;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [977. Squares of a Sorted Array - EASY](https://leetcode.com/problems/squares-of-a-sorted-array/)
 *
 * - two pointer
 * - start solving from reverse, 3 pointers left, right, index
 *
 * https://www.youtube.com/watch?v=FPCZsG_AkUg&ab_channel=NeetCode
 */
public class SquaresOfSortedArray {

    @Test
    public void test() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        Assertions.assertArrayEquals(expected, sortedSquares(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] expected = {4, 9, 9, 49, 121};
        Assertions.assertArrayEquals(expected, sortedSquares(nums));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        //Note that its <=
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
