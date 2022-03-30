package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Shell sort - HARD]()
 *
 * - improvement on insertion sort. Problem in insertion sort can lead to lot of shifting.
 * - Sort only the xth element.
 * - Sort only x-1th element. reduce gap each time.
 * - Use insertion sort at the end.
 * - interval picked by knuth sequence: h = 3h+1 , This way shifting in insertion sort will be reduced.
 */
public class _06_ShellSort {

    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        shellSort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    /**
     * Time: Best case : O(nlogn)
     * Time: Average case : O(n(logn)^2)
     * Time: Worst case : O(n(logn)^2)
     */
    public void shellSort(int arr[]) {
        int increment = arr.length / 2;
        while (increment > 0) {
            for (int i = increment; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j >= increment && arr[j - increment] > temp) {
                    arr[j] = arr[j - increment];
                    j = j - increment;
                }
                arr[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
