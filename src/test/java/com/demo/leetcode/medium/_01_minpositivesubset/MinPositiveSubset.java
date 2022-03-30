package com.demo.leetcode.medium._01_minpositivesubset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Smallest Positive Integer - MEDIUM]()
 *
 * - Given a sorted array of positive integers, find out the smallest integer which cannot be represented as the sum of any subset of the array
 */
public class MinPositiveSubset {

    @Test
    public void test1() {
        int[] nums = {1, 1, 1};
        Assertions.assertEquals(4, findMin(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 6, 7, 9};
        Assertions.assertEquals(4, findMin(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 3, 4, 6, 7, 9};
        Assertions.assertEquals(32, findMin(nums));
    }

    /**
     * https://algorithms.tutorialhorizon.com/minimum-number-that-cannot-be-formed-by-any-subset-of-an-array/
     * https://medium.com/dexters-lab/eli5-find-the-smallest-positive-integer-value-that-cannot-be-represented-as-sum-of-any-subset-of-f8ea2488184b
     */
    public int findMin(int arr[]) {
        int smallNum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= smallNum) {
                smallNum += arr[i];
            } else {
                break;
            }
        }
        return smallNum;
    }
}
