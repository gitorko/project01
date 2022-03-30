package com.demo.leetcode.medium._09_longestincreasingsubseq_300;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [300. Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/longest-increasing-subsequence/)
 *
 * - start reverse, dp, fill 1
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=cjWnW0hdF1Y&ab_channel=NeetCode
 */
public class LongestIncreasingSubSeq {

    @Test
    public void test() {
        int nums[] = {1, 2, 4, 3};
        Assertions.assertEquals(3, lengthOfLIS(nums));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     *
     * brute force takes O(2^n)
     * Here we are only finding the length of the longest increasing subsequence in
     * Similar to: 673. https://leetcode.com/problems/number-of-longest-increasing-subsequence/
     * we are counting how many such subsequence exists.
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}
