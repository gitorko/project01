package com.demo.leetcode.hard._15_distinctsubseq_115;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [115. Distinct Subsequences - HARD](https://leetcode.com/problems/distinct-subsequences/)
 *
 * - 2D DP
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * https://youtu.be/-RDzMJ33nx8
 */
public class DistinctSubSeq {

    @Test
    public void test1() {
        Assertions.assertEquals(3, numDistinct("rabbbit", "rabbit"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, numDistinct("a", ""));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(0, numDistinct("", "a"));
    }

    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    public int numDistinct(String s, String t) {

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // First row & first column indicate that no selection so will always match.
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
