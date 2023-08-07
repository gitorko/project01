package com.demo.leetcode.medium._05_subarraykavgthreshold_1343;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold - MEDIUM](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/)
 *
 * - sliding window
 *
 * https://www.youtube.com/watch?v=D8B4tKxMTnY&ab_channel=NeetCodeIO
 */
public class SubarrayKThreshold {

    @Test
    public void test() {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3, threshold = 4;
        Assertions.assertEquals(3, numOfSubarrays(arr, k, threshold));
        Assertions.assertEquals(3, numOfSubarrays2(arr, k, threshold));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int curSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            curSum += arr[right];
            int window = right - left + 1;
            if (window == k) {
                if (curSum / k >= threshold) {
                    count++;
                }
                curSum -= arr[left];
                left++;
            }
        }
        return count;
    }

    /**
     * prefix sum
     * Time: O(n)
     * Space: O(n)
     */
    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int n = arr.length;
        int count = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        for (int i = 0; i + k < n + 1; i++) {
            int average = (prefixSum[i + k] - prefixSum[i]) / k;
            if (average >= threshold) {
                count++;
            }
        }
        return count;
    }
}
