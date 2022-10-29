package com.demo.leetcode.medium._10_rotatearray_189;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [189. Rotate Array - MEDIUM](https://leetcode.com/problems/rotate-array/)
 *
 * - edge case k can be bigger than array use k % nums.length;
 * - reverse array 3 times, two pointer approach - no extra memory.
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=BHr381Guz3Y&ab_channel=NeetCode
 */
public class RotateArray {

    @Test
    public void test() {
        int expect[] = {5, 1, 2, 3, 4};
        int nums[] = {1, 2, 3, 4, 5};
        rotate(nums, 1);
        Assertions.assertArrayEquals(expect, nums);
    }

    @Test
    public void test2_twoElements() {
        int expect[] = {2, 1};
        int nums[] = {1, 2};
        rotate(nums, 3);
        Assertions.assertArrayEquals(expect, nums);
    }

    @Test
    public void test2_oneElement() {
        int expect[] = {1};
        int nums[] = {1};
        rotate(nums, 1);
        Assertions.assertArrayEquals(expect, nums);
    }

    @Test
    public void test_other() {
        int expect[] = {5, 1, 2, 3, 4};

        int nums1[] = {1, 2, 3, 4, 5};
        rotate1(nums1, 1);
        Assertions.assertArrayEquals(expect, nums1);

        int nums2[] = {1, 2, 3, 4, 5};
        rotate2(nums2, 1);
        Assertions.assertArrayEquals(expect, nums2);

    }

    @Test
    public void test3_emptyArray() {
        //check for divide by zero error
        int expect[] = {};
        int nums[] = {};
        rotate(nums, 2);
        Assertions.assertArrayEquals(expect, nums);
    }

    /**
     * Reverse whole array then reverse 2 sections - two pointer
     *
     * Time: O(n)
     * Space: O(1)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Uses extra space, with system lib copy.
     */
    public void rotate1(int[] nums, int k) {
        //Edge case when k is bigger than array.
        k %= nums.length;
        int[] set1 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int[] set2 = Arrays.copyOfRange(nums, 0, nums.length - k);
        System.arraycopy(set1, 0, nums, 0, set1.length);
        System.arraycopy(set2, 0, nums, set1.length, set2.length);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Uses extra space array, copies back to original array at end.
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

}
