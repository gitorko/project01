package com.demo.leetcode.medium._13_firstlastelement_34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [34. Find First and Last Position of Element in Sorted Array - MEDIUM](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
 *
 * - binary search and expand
 * - two binary search with leftBias, index = mid
 *
 * https://www.youtube.com/watch?v=4sQL7R5ySUU&ab_channel=NeetCode
 */
public class FirstLastElement {

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, searchRange(nums, 8));
        Assertions.assertArrayEquals(expected, searchRange2(nums, 8));
    }

    @Test
    public void test2() {
        int[] nums = {1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10};
        int[] expected = {1, 9};
        Assertions.assertArrayEquals(expected, searchRange(nums, 8));
        Assertions.assertArrayEquals(expected, searchRange2(nums, 8));
    }

    /**
     * Time: O(log n)
     * run binary search twice
     * better approach if all nums are target.
     */
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target, boolean leftBias) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                index = mid;
                if (leftBias) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return index;
    }

    /**
     * Time: O(n)
     * binary search, expand around index
     * expand approach will give O(n) if all input is target
     */
    public int[] searchRange2(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[]{-1, -1};
        return expandCenter(nums, index, target);
    }

    public int[] expandCenter(int[] arr, int index, int target) {
        int left = index;
        int right = index;
        while (left - 1 >= 0 && arr[left - 1] == target) left--;
        while (right + 1 < arr.length && arr[right + 1] == target) right++;
        return new int[]{left, right};
    }

    public int binarySearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
