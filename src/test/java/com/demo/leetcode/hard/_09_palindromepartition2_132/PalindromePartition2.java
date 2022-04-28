package com.demo.leetcode.hard._09_palindromepartition2_132;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [132. Palindrome Partitioning II - HARD](https://leetcode.com/problems/palindrome-partitioning-ii/)
 *
 * - dp
 *
 * https://www.youtube.com/watch?v=lDYIvtBVmgo&ab_channel=TusharRoy-CodingMadeSimple
 */
public class PalindromePartition2 {

    @Test
    public void test() {
        Assertions.assertEquals(1, minCut("aab"));
    }

    /**
     * Time: O(n^2)
     * Space : O(n^2)
     */
    public int minCut(String s) {
        int n = s.length();
        int cuts[] = new int[n];
        boolean dp[][] = new boolean[n][n];
        for (int i = 1; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i <= j + 1 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cuts[j - 1]);
                }
            }
            cuts[i] = min;
        }
        return cuts[n - 1];
    }
}
