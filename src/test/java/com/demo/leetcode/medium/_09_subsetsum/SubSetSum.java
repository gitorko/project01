package com.demo.leetcode.medium._09_subsetsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [SubSet Sum - MEDIUM]()
 *
 * - Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to the given sum.
 * - SIMILAR_TO: [0/1 knapsack - MEDIUM]()
 * - SIMILAR_TO: [40. Combination Sum II - MEDIUM](https://leetcode.com/problems/combination-sum-ii/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=s6FhG--P7z0&ab_channel=TusharRoy-CodingMadeSimple
 */
public class SubSetSum {

    @Test
    public void test1() {
        int[] arr = {1, 5, 6, 3};
        int target = 8;
        Assertions.assertTrue(subSetSum(arr, target));
        Assertions.assertTrue(subSetSum2(arr, target));
    }

    @Test
    public void test2() {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;
        Assertions.assertTrue(subSetSum(arr, target));
        Assertions.assertTrue(subSetSum2(arr, target));
    }

    @Test
    public void test3() {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 30;
        Assertions.assertFalse(subSetSum(arr, target));
        Assertions.assertFalse(subSetSum2(arr, target));
    }

    @Test
    public void test4() {
        int[] arr = {2, 3, 7, 8, 10};
        int target = 11;
        Assertions.assertTrue(subSetSum(arr, target));
        Assertions.assertTrue(subSetSum2(arr, target));
    }

    /**
     * Time: O(target * n)
     * Space: O(target * n)
     */
    public boolean subSetSum(int arr[], int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int currVal = arr[i - 1];
                if (currVal > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - currVal];
                }
            }
        }
        return dp[arr.length][target];
    }

    /**
     * Uses less space as it stores only one previous row.
     * Time: O(target * n)
     * Space: O(target)
     */
    public boolean subSetSum2(int arr[], int target) {
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < arr.length + 1; i++) {
            int currVal = arr[i - 1];
            for (int j = target; j >= currVal; j--) {
                dp[j] = dp[j] || dp[j - currVal];
            }
        }
        return dp[target];
    }
}
