package com.demo.basics.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Bucket sort - EASY]()
 *
 * - create bins array based on 10,100s position. 0-9 for decimal.
 * - store in 100th position in linked list.
 * - sort linked list using insertion sort.
 * - read and write to result.
 */
public class _09_BucketSort {

    @Test
    public void test() {
        int arr[] = {2, 6, 5, 3, 4, 1};
        int expected[] = {1, 2, 3, 4, 5, 6};
        bucketSort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    /**
     * Time: Best case : O(n+k)
     * Time: Average case : O(n+k)
     * Time: Worst case : O(n^2)
     */
    private void bucketSort(int[] arr) {
        //get max value of arr
        int max = max(arr);
        //get min value of arr
        int min = min(arr);
        //number of buckets
        int numberOfBuckets = max - min + 1;
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        //init buckets
        for (int i = 0; i < numberOfBuckets; ++i) {
            buckets.add(new ArrayList<>());
        }
        //store elements to buckets
        for (int value : arr) {
            int hash = hash(value, min, numberOfBuckets);
            buckets.get(hash).add(value);
        }
        //sort individual bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        //concatenate buckets to origin array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    /**
     * Get index of bucket which of our elements gets placed into it.
     */
    private int hash(int elem, int min, int numberOfBucket) {
        return (elem - min) / numberOfBucket;
    }

    /**
     * Calculate max value of array
     */
    public int max(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Calculate min value of array
     */
    public int min(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
