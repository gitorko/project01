package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [MergeSort - MEDIUM]()
 * [912. Sort an Array - MEDIUM](https://leetcode.com/problems/sort-an-array/)
 *
 * - recursive algorithm + pick a mid
 * - uses extra memory.
 * - good for large sorting.
 */
public class _04_MergeSort {

    @Test
    public void test() {
        int arr[] = {6, 5, 3, 4, 2, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, sortArray(arr));
    }

    /**
     * Time: Best case : O(n log(n))
     * Time: Average case : O(n log(n))
     * Time: Worst case : O(n log(n))
     * Space: O(n)
     */
    public int[] sortArray(int[] arr) {
        return mergesort(arr, 0, arr.length - 1);
    }

    public int[] mergesort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergesort(arr, start, mid);
            mergesort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }

    void merge(int arr[], int start, int mid, int end) {
        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        // add elements left in the first interval
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        // add elements left in the second interval
        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // copy temp to original interval
        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
    }

}
