package com.demo.leetcode.medium._09_longestcommonsubsequence_1143;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * - 2D DP
 * - solve from reverse
 * - if match go diagonal, if no match go right and go down and get max
 * - SIMILAR_TO: [115. Distinct Subsequences - HARD](https://leetcode.com/problems/distinct-subsequences/)
 * - SIMILAR_TO: [72. Edit Distance - HARD](https://leetcode.com/problems/edit-distance/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Ua0GhsJSlWM&ab_channel=NeetCode
 */
public class LongestCommonSubSequence {

    @Test
    public void test1() {
        String text1 = "abcde", text2 = "ace";
        Assertions.assertEquals(3, longestCommonSubsequence(text1, text2));
    }

    @Test
    public void test2() {
        String text1 = "ace", text2 = "abcde";
        Assertions.assertEquals(3, longestCommonSubsequence(text1, text2));
    }


    /**
     * Bottom up
     * Time: O(m * n)
     * Space: O(m * n)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
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
