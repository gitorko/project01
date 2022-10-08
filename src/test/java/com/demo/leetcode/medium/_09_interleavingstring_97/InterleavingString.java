package com.demo.leetcode.medium._09_interleavingstring_97;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [97. Interleaving String - MEDIUM](https://leetcode.com/problems/interleaving-string/)
 *
 * - dp, start from reverse
 * - go down or right
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=3Rw3p9LrgvE&ab_channel=NeetCode
 */
public class InterleavingString {

    @Test
    public void test1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Assertions.assertTrue(isInterleave(s1, s2, s3));
    }

    @Test
    public void test2() {
        String s1 = "ace", s2 = "abcde", s3 = "aacbcdee";
        Assertions.assertTrue(isInterleave(s1, s2, s3));
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len + s2Len != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
        dp[s1Len][s2Len] = true;

        for (int i = s1Len; i >= 0; i--) {
            for (int j = s2Len; j >= 0; j--) {
                //first char
                if (i < s1Len && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                //second char
                if (j < s2Len && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

}
