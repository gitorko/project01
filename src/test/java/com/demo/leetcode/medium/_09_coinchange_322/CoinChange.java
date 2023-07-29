package com.demo.leetcode.medium._09_coinchange_322;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [322. Coin Change - MEDIUM](https://leetcode.com/problems/coin-change/)
 *
 * - 1D DP, fill max value
 * - unbounded knapsack, but we are checking min here instead of max.
 * - SIMILAR_TO: [SubSet Sum - MEDIUM]()
 * - SIMILAR_TO: [518. Coin Change 2 - MEDIUM](https://leetcode.com/problems/coin-change-2/)
 * - SIMILAR_TO: [279. Perfect Squares - MEDIUM](https://leetcode.com/problems/perfect-squares/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=H9bfqozjoqs&ab_channel=NeetCode
 */
public class CoinChange {

    @Test
    public void test1() {
        int coins[] = {1, 2, 5}, amount = 11;
        Assertions.assertEquals(3, coinChange(coins, amount));
        Assertions.assertEquals(3, coinChange2(coins, amount));
    }

    @Test
    public void test2() {
        int coins[] = {1}, amount = 0;
        Assertions.assertEquals(0, coinChange(coins, amount));
        Assertions.assertEquals(0, coinChange2(coins, amount));
    }

    /**
     * Bottom up - iterative
     * Time: O(amount * len(coins)).
     * Space: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //amount + 1 is considered as max value
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a < amount + 1; a++) {
            for (int coin : coins) {
                int diff = a - coin;
                if (diff >= 0) {
                    //remember to add +1
                    dp[a] = Math.min(dp[a], 1 + dp[diff]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * Recursion - Top down
     * Time: O(s * n). where s is the amount, n is denomination count.
     * Space: O(s)
     */
    int[] dp;
    int[] coins;

    public int coinChange2(int[] coins, int amount) {
        this.coins = coins;
        if (amount < 1) {
            return 0;
        }
        dp = new int[amount];
        return helper(amount);
    }

    private int helper(int rem) {
        //base case
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (dp[rem - 1] != 0) {
            return dp[rem - 1]; // already computed, so reuse
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(rem - coin);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[rem - 1];
    }

}
