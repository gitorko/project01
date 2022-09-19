package com.demo.leetcode.medium._09_decodeways_91;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [91. Decode Ways - MEDIUM](https://leetcode.com/problems/decode-ways/)
 *
 * - 1D DP
 * - start from reverse n-2, isValid
 *
 * PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=6aEyTjOwlJU&ab_channel=NeetCode
 */
public class DecodeWays {

    @Test
    public void test() {
        Assertions.assertEquals(2, numDecodings("12"));
        Assertions.assertEquals(3, numDecodings("226"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // ""
        dp[n - 1] = isValid(s.charAt(n - 1)) ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (isValid(s.charAt(i)))
                dp[i] += dp[i + 1];
            if (isValid(s.charAt(i), s.charAt(i + 1)))
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }

    private boolean isValid(char c) {
        return c != '0';
    }

    //26 chars in english hence range is 1-26
    private boolean isValid(char c1, char c2) {
        return c1 == '1' || c1 == '2' && c2 < '7';
    }
}
