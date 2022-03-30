package com.demo.leetcode.medium._09_perfectsquare_279;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [279. Perfect Squares - MEDIUM](https://leetcode.com/problems/perfect-squares/)
 *
 * - dp
 * - SIMILAR_TO: [322. Coin Change - MEDIUM](https://leetcode.com/problems/coin-change/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=HLZLwjzIVGo&ab_channel=NeetCode
 */
public class PerfectSquare {

    @Test
    public void test1() {
        Assertions.assertEquals(3, numSquares(12));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, numSquares(13));
    }

    /**
     * Time: O(log(n))
     * Space: O(n*log(n))
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //n is max value
        Arrays.fill(dp, n); // 1^2 x n

        dp[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);

        return dp[n];
    }
}
