package com.demo.leetcode.hard._09_burstballoons_312;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [312. Burst Balloons - HARD](https://leetcode.com/problems/burst-balloons/)
 *
 * https://www.youtube.com/watch?v=VFskby7lUbw&ab_channel=NeetCode
 */
public class BurstBalloon {

    @Test
    public void test() {
        int[] nums = {3, 1, 5, 8};
        Assertions.assertEquals(167, maxCoins(nums));
    }

    /**
     * Time: O(n^3)
     * Space: O(n^2)
     */

    int[][] dp;
    int[] nums;

    public int maxCoins(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length][nums.length];
        return dfs(0, nums.length - 1);
    }

    public int dfs(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int max = nums[left];
        for (int i = left; i < right + 1; i++) {
            int leftVal = dfs(left, i - 1);
            int rightVal = dfs(i + 1, right);
            int midVal = getBoundary(i) * getBoundary(left - 1) * getBoundary(right + 1);
            max = Math.max(max, leftVal + rightVal + midVal);
        }
        dp[left][right] = max;
        return max;
    }

    public int getBoundary(int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        }
        return nums[i];
    }
}
