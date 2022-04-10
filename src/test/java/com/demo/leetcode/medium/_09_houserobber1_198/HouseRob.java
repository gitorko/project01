package com.demo.leetcode.medium._09_houserobber1_198;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [198. House Robber - MEDIUM](https://leetcode.com/problems/house-robber/)
 *
 * - rob = max (arr[0] + rob(2..n), rob(1..n))
 *
 * PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=73r3KWiEvyk&ab_channel=NeetCode
 */
public class HouseRob {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        Assertions.assertEquals(4, robTopDownRecursion(nums));
        Assertions.assertEquals(4, robBottomUp(nums));
        Assertions.assertEquals(4, robBottomUpNSteps(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2};
        Assertions.assertEquals(2, robTopDownRecursion(nums));
        Assertions.assertEquals(2, robBottomUp(nums));
        Assertions.assertEquals(2, robBottomUpNSteps(nums));
    }

    /**
     * Iterative Bottom up + Memoization
     */
    int[] dp;

    public int robBottomUp(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        //first and second house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //Start from 2nd house
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * Iterative + 2 Variables
     * rob2 was the most recent robbed house.
     */
    public int robBottomUpNSteps(int[] nums) {
        if (nums.length == 0) return 0;
        int rob1 = 0, rob2 = 0;
        //[rob1, rob2, n, n+1]
        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    /**
     * Recursive + Memoization
     * Time: O(N)
     * Space: O(N)
     */
    public int robTopDownRecursion(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robTopDownHelper(nums, nums.length - 1);
    }

    private int robTopDownHelper(int[] nums, int i) {
        if (i == 0)
            return nums[0];
        if (i == 1)
            return Math.max(nums[0], nums[1]);
        if (dp[i] >= 0) {
            return dp[i];
        }
        dp[i] = Math.max(nums[i] + robTopDownHelper(nums, i - 2), robTopDownHelper(nums, i - 1));
        return dp[i];
    }
}
