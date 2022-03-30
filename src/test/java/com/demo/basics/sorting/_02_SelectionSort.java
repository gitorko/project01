package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Selection sort - EASY]()
 *
 * - select the smallest number and swap.
 * - less swaps compared to bubble sort.
 * - running time is independent of ordering of elements. So running time doesnt vary if array is already sorted.
 * - better than bubble sort. Use insertion sort if array is nearly sorted.
 */
public class _02_SelectionSort {

    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, sortArray(arr));
    }

    /**
     * Time: Best case : O(N^2)
     * Time: Average case : O(N^2)
     * Time: Worst case : O(N^2)
     */
    public int[] sortArray(int[] arr) {
        return selectionSort(arr);
    }

    public int[] selectionSort(int arr[]) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            //System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

}
