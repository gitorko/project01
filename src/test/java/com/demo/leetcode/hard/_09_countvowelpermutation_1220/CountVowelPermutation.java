package com.demo.leetcode.hard._09_countvowelpermutation_1220;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1220. Count Vowels Permutation - HARD](https://leetcode.com/problems/count-vowels-permutation/)
 *
 * - 2D DP
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=VUVpTZVa7Ls&ab_channel=NeetCode
 */
public class CountVowelPermutation {

    @Test
    public void test() {
        Assertions.assertEquals(10, countVowelPermutation(2));
        Assertions.assertEquals(10, countVowelPermutation2(2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int countVowelPermutation(int n) {
        int modVal = (int) (1e9 + 7);
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        /*
            0: a
            1: e
            2: i
            3: o
            4: u
         */
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % modVal;
            dp[i + 1][1] = (dp[i][0] + dp[i][2]) % modVal;
            dp[i + 1][2] = (dp[i][3] + dp[i][1]) % modVal;
            dp[i + 1][3] = (dp[i][2]) % modVal;
            dp[i + 1][4] = (dp[i][2] + dp[i][3]) % modVal;
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n][i]) % modVal;
        }
        return (int) ans;
    }

    /**
     * less space, as it needs just the previous row
     * Time: O(n)
     * Space: O(1)
     */
    public int countVowelPermutation2(int n) {
        int modVal = (int) (1e9 + 7);
        long[] dp = new long[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        /*
            0: a
            1: e
            2: i
            3: o
            4: u
         */
        long[] nextDp;
        for (int i = 1; i < n; i++) {
            nextDp = new long[5];
            nextDp[0] = (dp[4] + dp[1] + dp[2]) % modVal;
            nextDp[1] = (dp[0] + dp[2]) % modVal;
            nextDp[2] = (dp[3] + dp[1]) % modVal;
            nextDp[3] = (dp[2]) % modVal;
            nextDp[4] = (dp[2] + dp[3]) % modVal;
            dp = nextDp;
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[i]) % modVal;
        }
        return (int) ans;
    }
}
