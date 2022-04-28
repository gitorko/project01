package com.demo.leetcode.medium._09_longestpalindromicsubseq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [516. Longest Palindromic Subsequence - MEDIUM](https://leetcode.com/problems/longest-palindromic-subsequence/)
 *
 * - dynamic program, (2d matrix)
 * - can be changed to - Minimum number of deletions to make a string palindrome
 * - SIMILAR_TO: [1143. Longest Common Subsequence - MEDIUM](https://leetcode.com/problems/longest-common-subsequence/)
 * - SIMILAR_TO: [1312. Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=_nCsPn7_OgI&ab_channel=TusharRoy-CodingMadeSimple
 */
public class LongestPalindromeSubSeq {

    @Test
    public void test() {
        Assertions.assertEquals(4, longestPalindromeSubseq("bbbab"));
        Assertions.assertEquals(2, longestPalindromeSubseq("cbbd"));
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public int longestPalindromeSubseq(String s) {
        String text1 = s;
        String text2 = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--)
            for (int j = text2.length() - 1; j >= 0; j--)
                if (text1.charAt(i) == text2.charAt(j))
                    //go diagonal
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[0][0];
    }
}
