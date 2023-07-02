package com.demo.leetcode.medium._09_coinchange2_518;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [518. Coin Change 2 - MEDIUM](https://leetcode.com/problems/coin-change-2/)
 *
 * - dp (2d)
 * - unbounded knapsack
 * - no duplicates
 * - SIMILAR_TO: Count of Subsets Sum with a Given Sum
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Mjy4hd2xgrs&ab_channel=NeetCode
 */
public class CoinChange2 {

    @Test
    public void test() {
        int coins[] = {1, 2, 5}, amount = 5;
        Assertions.assertEquals(4, change(amount, coins));
        Assertions.assertEquals(4, change2(amount, coins));
        Assertions.assertEquals(4, change3(amount, coins));
    }

    /**
     * Iterative - DP
     * Time: O(m*n) , m is total coins, n is amount
     * Space: O(m*n)
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i < coins.length + 1; i++) {
            //coins[i-1] because coins array starts from 0 index.
            int coin = coins[i - 1];
            dp[i][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coin ? dp[i][j - coin] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]],
     * then we can optimize the space by only using one-dimension array.
     * Time: O(m*n) , m is total coins, n is amount
     * Space: O(n)
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    /**
     * bottom up
     * Time: O(m*n) , m is total coins, n is amount
     * Space: O(m*n)
     */
    int[][] dp;
    int[] coins;

    public int change3(int amount, int[] input) {
        coins = input;
        dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, amount);
    }

    int dfs(int i, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int ans = dfs(i + 1, amount); // skip ith coin
        if (amount >= coins[i]) {
            ans += dfs(i, amount - coins[i]); // use ith coin
        }
        dp[i][amount] = ans;
        return dp[i][amount];
    }

}
