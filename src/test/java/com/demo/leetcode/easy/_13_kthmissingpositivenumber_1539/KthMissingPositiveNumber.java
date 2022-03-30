package com.demo.leetcode.easy._13_kthmissingpositivenumber_1539;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1539. Kth Missing Positive Number - EASY](https://leetcode.com/problems/kth-missing-positive-number/)
 *
 * - arr[mid] - mid - 1 >= k
 * - SIMILAR_TO: Find the first k missing positive numbers
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=88k8xa-pSrM&ab_channel=AlgorithmsMadeEasy
 */
public class KthMissingPositiveNumber {

    @Test
    public void test1() {
        int[] arr = {2, 3, 4, 7, 11};
        Assertions.assertEquals(9, findKthPositive(arr, 5));
        Assertions.assertEquals(9, findKthPositive2(arr, 5));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        Assertions.assertEquals(6, findKthPositive2(arr, 1));
        Assertions.assertEquals(7, findKthPositive2(arr, 2));
    }

    /**
     * Time: O(log(n))
     * Space: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] - mid - 1 >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left + k;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int findKthPositive2(int[] arr, int k) {
        int i = 1;
        int j = 0;
        while (k > 0) {
            if (j < arr.length && arr[j] == i) {
                j++;
                i++;
                continue;
            }
            i++;
            k--;
        }
        return i - 1;
    }
}
