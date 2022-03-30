package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Insertion sort - EASY]()
 *
 * - less swaps compared to bubble sort.
 * - good for small lists. Better for nearly sorted list.
 * - stable vs unstable (5 vs 5' if numbers are not swapped then stable.)
 * - Eg: deck of cards.
 */
public class _03_InsertionSort {

    @Test
    public void test() {
        int arr[] = {6, 5, 3, 4, 2, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(sortArray(arr), expected);
    }

    /**
     * Time: Best case: O(n)
     * Time: Average case: O(n^2)
     * Time: Worst case: O(n^2)
     */
    public int[] sortArray(int[] arr) {
        return insertionSort(arr);
    }

    public int[] insertionSort(int arr[]) {
        int current, j;
        for (int i = 0; i < arr.length; i++) {
            current = arr[i];
            j = i - 1;
            //shift
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
        return arr;
    }
}
