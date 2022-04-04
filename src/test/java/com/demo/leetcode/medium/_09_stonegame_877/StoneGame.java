package com.demo.leetcode.medium._09_stonegame_877;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [877. Stone Game - MEDIUM](https://leetcode.com/problems/stone-game/)
 *
 * - dp
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=uhgdXOlGYqE&ab_channel=NeetCode
 */
public class StoneGame {

    @Test
    public void test() {
        int[] piles = {5, 3, 4, 5};
        Assertions.assertTrue(stoneGame(piles));
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = Math.max(piles[j] - dp[j + 1][j + i], piles[j + i] - dp[j][j + i - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public boolean stoneGame2(int[] piles) {
        int[] dp = Arrays.copyOf(piles, piles.length);
        for (int i = 1; i < piles.length; i++)
            for (int j = 0; j < piles.length - i; j++)
                dp[j] = Math.max(piles[j] - dp[j + 1], piles[j + i] - dp[j]);
        return dp[0] > 0;
    }
}
