package com.demo.leetcode.hard._15_distinctsubseq_115;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [115. Distinct Subsequences - HARD](https://leetcode.com/problems/distinct-subsequences/)
 *
 * - 2D DP
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * https://www.youtube.com/watch?v=-RDzMJ33nx8&ab_channel=NeetCode
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
        // First row means no selection so will always match.
        for (int j = 0; j < s.length() + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    //previous exact match + previous without match
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    //previous without match
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

}
