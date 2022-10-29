package com.demo.leetcode.medium._09_uncrossedline_1035;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1035. Uncrossed Lines - MEDIUM](https://leetcode.com/problems/uncrossed-lines/)
 *
 * - DP
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * https://www.youtube.com/watch?v=mnJF4vJ7GyE&ab_channel=NeetCodeIO
 */
public class UncrossedLine {

    @Test
    public void test() {
        int[] nums1 = {1, 4, 2}, nums2 = {1, 2, 4};
        Assertions.assertEquals(2, maxUncrossedLines(nums1, nums2));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    //go diagonal
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
