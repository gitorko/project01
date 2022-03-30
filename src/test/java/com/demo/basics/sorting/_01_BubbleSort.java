package com.demo.basics.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Bubble Sort - EASY]()
 *
 * - Too many swaps.
 */
public class _01_BubbleSort {

    @Test
    public void test() {
        int expected[] = {1, 2, 3, 4, 5, 6};

        int arr1[] = {1, 2, 6, 5, 3, 4};
        Assertions.assertArrayEquals(expected, bubbleLeft(arr1));
        System.out.println("");

        int arr2[] = {2, 6, 5, 3, 4, 1};
        Assertions.assertArrayEquals(expected, bubbleRight(arr2));

    }

    /**
     * Time: Best case: O(n)
     * Time: Average case: O(n^2)
     * Time: Worst case: O(n^2)
     *
     * Smaller element bubbles to the front.
     */
    public int[] bubbleLeft(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    //swap
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * Larger element bubbles to the end.
     */
    public int[] bubbleRight(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
