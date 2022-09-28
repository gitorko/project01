package com.demo.leetcode.medium._01_minpositivesubset;

import java.util.HashSet;
import java.util.Set;

import com.demo.leetcode.medium._09_integerbreak_343.IntegerBreak;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Smallest Positive Integer - MEDIUM]()
 *
 * - Given a sorted array of positive integers,elements need not be distinct
 * - find out the smallest integer which cannot be represented as the sum of any subset of the array
 * - PRACTICE: P3
 *
 * https://algorithms.tutorialhorizon.com/minimum-number-that-cannot-be-formed-by-any-subset-of-an-array/
 * https://medium.com/dexters-lab/eli5-find-the-smallest-positive-integer-value-that-cannot-be-represented-as-sum-of-any-subset-of-f8ea2488184b
 */
public class MinPositiveSubset {

    @Test
    public void test1() {
        int[] nums = {1, 1, 1};
        Assertions.assertEquals(4, findMin(nums));
        Assertions.assertEquals(4, findMin2(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 6, 7, 9};
        Assertions.assertEquals(4, findMin(nums));
        Assertions.assertEquals(4, findMin2(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 3, 4, 6, 7, 9};
        Assertions.assertEquals(32, findMin(nums));
        Assertions.assertEquals(32, findMin2(nums));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int findMin(int arr[]) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> tempSet = new HashSet<>(numSet);
            for (Integer n : tempSet) {
                numSet.add(n + arr[i]);
            }
            numSet.add(arr[i]);
        }
        int i = 1;
        while (true) {
            if (!numSet.contains(i)) return i;
            i++;
        }
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int findMin2(int arr[]) {
        int smallNum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smallNum) {
                break;
            }
            smallNum += arr[i];
        }
        return smallNum;
    }
}
