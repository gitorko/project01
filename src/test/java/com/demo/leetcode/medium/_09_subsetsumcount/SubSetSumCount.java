package com.demo.leetcode.medium._09_subsetsumcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [SubSet Sum Count - MEDIUM]()
 *
 * - Given a set of non-negative integers, and a value sum, determine how many subset of the given set with sum equal to the given sum.
 * - SIMILAR_TO: [SubSet Sum - MEDIUM]()
 * - PRACTICE: P1
 */
public class SubSetSumCount {

    @Test
    public void test1() {
        int[] arr = {1, 2, 1};
        int target = 3;
        Assertions.assertEquals(2, subSetSumCount(arr, target));
    }

    @Test
    public void test2() {
        int[] arr = {2, 3, 4, 5};
        int target = 7;
        Assertions.assertEquals(2, subSetSumCount(arr, target));
    }

    /**
     * Time: O(target * n)
     * Space: O(target * n)
     */
    public int subSetSumCount(int arr[], int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int currVal = arr[i - 1];
                if (currVal > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - currVal];
                }
            }
        }
        return dp[arr.length][target];
    }
}
