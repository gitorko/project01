package com.demo.theory._002_heapify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.geeksforgeeks.org/building-heap-from-array/
 *                 1
 *              /      \
 *             3        5
 *           /   \     / \
 *         4       6 13   10
 *       / \    /  \
 *      9   8 15    17
 *
 * TYPE: HARD
 *
 */
public class HeapAnArray {

    @Test
    public void test() {
        int nums[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int expected[] = {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};
        buildHeap(nums, nums.length);
        Assertions.assertArrayEquals(expected, nums);
    }

    public void buildHeap(int arr[], int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

}
