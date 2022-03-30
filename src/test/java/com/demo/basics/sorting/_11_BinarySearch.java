package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Binary Search - EASY]()
 * [704. Binary Search - EASY](https://leetcode.com/problems/binary-search/)
 *
 * - Works only on ordered array.
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
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                index = mid;
                break;
            }
        }
        return index;
    }

    /**
     * Recursion
     * Time: O(log(n))
     * Space: O(n)
     */
    public int binarySearchRecursive(int arr[], int key) {
        return bsRecursiveHelper(arr, key, 0, arr.length - 1);
    }

    private int bsRecursiveHelper(int[] arr, int key, int low, int high) {
        int middle = (low + high) / 2;
        //base case
        if (high < low) {
            return -1;
        }
        if (key == arr[middle]) {
            return middle;
        } else if (key < arr[middle]) {
            return bsRecursiveHelper(arr, key, low, middle - 1);
        } else {
            return bsRecursiveHelper(arr, key, middle + 1, high);
        }
    }
}
