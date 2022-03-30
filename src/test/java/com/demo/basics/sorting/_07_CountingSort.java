package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Counting sort - EASY]()
 *
 * - Linear time algo. need to know the range. eg: 0-10
 * - need extra memory to store count.
 * - Not suitable when range is large.
 */
public class _07_CountingSort {
    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        countingSort(arr, 6);
        Assertions.assertArrayEquals(expected, arr);
    }

    /**
     * Time: Best case : O(n+k) where k is temp array.
     * Time: Average case : O(n+k)
     * Time: Worst case : O(n+k)
     * Space: O(n)
     */
    private void countingSort(int[] arr, int k) {
        // create buckets
        int counter[] = new int[k + 1];
        // fill buckets
        for (int i : arr) {
            counter[i]++;
        }

        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                arr[index++] = i;
                counter[i]--;
            }
        }
    }
}
