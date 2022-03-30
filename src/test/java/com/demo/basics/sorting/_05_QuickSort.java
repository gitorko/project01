package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [QuickSort - MEDIUM]()
 * [912. Sort an Array - MEDIUM](https://leetcode.com/problems/sort-an-array/)
 *
 * - choose pivot element
 * - partition - move all element less of pivot to left, element greater than pivot to right.
 * - recursive sort left and right
 * - no additional space, in-place sorting compared to merge sort
 * - Will run into stack overflow if the array is too large.
 */
public class _05_QuickSort {

    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, sortArray(arr));
    }

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * Time: Best case : O(n log(n))
     * Time: Average case : O(n log(n))
     * Time: Worst case : O(n^2)
     */
    private void quicksort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[(left + right) / 2];
        int index = partition(nums, left, right, pivot);

        quicksort(nums, left, index - 1);
        quicksort(nums, index, right);
    }

    private int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (nums[left] < pivot) {
                left++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
