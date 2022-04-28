package com.demo.leetcode.hard._09_editdistance_72;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [72. Edit Distance - HARD](https://leetcode.com/problems/edit-distance/)
 *
 * - min of 3 sides
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=XYi2-LPrwm4&ab_channel=NeetCode
 */
public class EditDistance {

    @Test
    public void test1() {
        Assertions.assertEquals(3, minDistance("horse", "ros"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, minDistance("abd", "acd"));
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        //fill last row
        for (int i = n; i >= 0; i--)
            dp[m][i] = n - i;

        //fill last column
        for (int i = m; i >= 0; i--)
            dp[i][n] = m - i;

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));

        return dp[0][0];
    }
}
