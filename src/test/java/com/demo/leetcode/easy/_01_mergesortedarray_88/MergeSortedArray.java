package com.demo.leetcode.easy._01_mergesortedarray_88;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [88. Merge Sorted Array - EASY](https://leetcode.com/problems/merge-sorted-array/)
 *
 * - two pointer, start from reverse
 *
 * https://www.youtube.com/watch?v=P1Ic85RarKY&ab_channel=NeetCode
 */
public class MergeSortedArray {

    @Test
    public void test1() {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = 3, n = 3;
        int expected[] = {1, 2, 2, 3, 5, 6};
        merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }

    @Test
    public void test_2ndArrayEmpty() {
        int nums1[] = {1};
        int nums2[] = {};
        int m = 1, n = 0;
        int expected[] = {1};
        merge(nums1, m, nums2, n);
        Assertions.assertArrayEquals(expected, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] > nums2[tail2]) {
                nums1[finished--] = nums1[tail1--];
            } else {
                nums1[finished--] = nums2[tail2--];
            }
        }
        //fill nums1 with leftover from nums2
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }

}
