package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [704. Binary Search - EASY](https://leetcode.com/problems/binary-search/)
 *
 * - Works only on sorted array.
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=s4DPM8ct1pI&ab_channel=NeetCode
 */
public class _11_BinarySearch {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assertions.assertEquals(binarySearchIterative(arr, 5), 4);
        Assertions.assertEquals(binarySearchIterative(arr, 11), -1);
        Assertions.assertEquals(binarySearchRecursive(arr, 5), 4);
        Assertions.assertEquals(binarySearchRecursive(arr, 11), -1);
    }

    /**
     * Time: O(log(n))
     * Space: O(1)
     */
    public int binarySearchIterative(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //prevent overflow (left + ((right - left)/2))
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Recursion
     * Time: O(log(n))
     * Space: O(n)
     */
    int arr[];
    int key;

    public int binarySearchRecursive(int arr[], int key) {
        this.arr = arr;
        this.key = key;
        return helper(0, arr.length - 1);
    }

    private int helper(int left, int right) {
        int mid = (left + right) / 2;
        //base case
        if (right < left) {
            return -1;
        }
        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            return helper(left, mid - 1);
        } else {
            return helper(mid + 1, right);
        }
    }
}
