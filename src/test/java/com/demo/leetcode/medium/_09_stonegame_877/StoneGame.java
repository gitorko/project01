package com.demo.leetcode.medium._09_stonegame_877;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [877. Stone Game - MEDIUM](https://leetcode.com/problems/stone-game/)
 *
 * - dp
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=uhgdXOlGYqE&ab_channel=NeetCode
 */
public class StoneGame {

    @Test
    public void test() {
        int[] piles = {5, 3, 4, 5};
        Assertions.assertTrue(stoneGame(piles));
        Assertions.assertTrue(stoneGame2(piles));
        Assertions.assertTrue(stoneGame3(piles));
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    Map<String, Integer> dp;
    int[] piles;

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        dp = new HashMap<>();
        int sum = Arrays.stream(piles).sum();
        return dfs(0, piles.length - 1) > sum / 2;
    }

    public int dfs(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp.containsKey(left + "_" + right)) {
            return dp.get(left + "_" + right);
        }
        boolean evenElements = (right - left) % 2 == 0;
        int leftVal = 0;
        int rightVal = 0;
        if (evenElements) {
            //alice making the choice
            leftVal = piles[left];
            rightVal = piles[right];
        } else {
            //bob making choice
            leftVal = 0;
            rightVal = 0;
        }
        int val = Math.max(dfs(left + 1, right) + leftVal, dfs(left, right - 1) + rightVal);
        dp.put(left + "_" + right, val);
        return dp.get(left + "_" + right);
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[] dp = Arrays.copyOf(piles, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j] = Math.max(piles[j] - dp[j + 1], piles[j + i] - dp[j]);
            }
        }
        return dp[0] > 0;
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public boolean stoneGame3(int[] piles) {
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
}
