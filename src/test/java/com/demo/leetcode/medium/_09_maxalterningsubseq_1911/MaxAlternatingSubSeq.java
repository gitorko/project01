package com.demo.leetcode.medium._09_maxalterningsubseq_1911;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1911. Maximum Alternating Subsequence Sum - MEDIUM](https://leetcode.com/problems/maximum-alternating-subsequence-sum/)
 *
 * - dp 2d
 * - tempEven, tempOdd
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=4v42XOuU1XA&ab_channel=NeetCode
 */
public class MaxAlternatingSubSeq {

    @Test
    public void test() {
        int[] nums = {4, 2, 5, 3};
        Assertions.assertEquals(7, maxAlternatingSum(nums));
        Assertions.assertEquals(7, maxAlternatingSum2(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public long maxAlternatingSum(int[] nums) {
        long sumEven = 0;
        long sumOdd = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long tempEven = Math.max(sumOdd + nums[i], sumEven);
            long tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }
        return sumEven;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    long[][] dp;
    int[] nums;

    public long maxAlternatingSum2(int[] nums) {
        dp = new long[nums.length + 1][2];
        this.nums = nums;
        dfs(0, true);
        return dp[0][0];
    }

    private long dfs(int i, boolean even) {
        if (i == nums.length)
            return 0;
        if (dp[i][even ? 0 : 1] != 0)
            return dp[i][even ? 0 : 1];

        int num = even ? nums[i] : -1 * nums[i];
        long result = Math.max(num + dfs(i + 1, !even), dfs(i + 1, even));
        dp[i][even ? 0 : 1] = result;
        return dp[i][even ? 0 : 1];
    }
}
