package com.demo.leetcode.medium._09_unboundedknapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Unbounded knapsack - MEDIUM]()
 *
 * - SIMILAR_TO: [0/1 knapsack - MEDIUM]()
 * - SIMILAR_TO: [322. Coin Change - MEDIUM](https://leetcode.com/problems/coin-change/)
 * - PRACTICE: P1
 */
public class UnboundedKnapSack {

    @Test
    public void test1() {
        int weight = 100;
        int[] weights = {5, 10, 15};
        int[] values = {10, 30, 20};
        Assertions.assertEquals(300, unboundedKnapsack(weight, weights, values));
    }

    public int unboundedKnapsack(int weight, int[] weights, int[] values) {
        int[] dp = new int[weight + 1];
        for (int w = 1; w < weight + 1; w++) {
            for (int j = 0; j < values.length; j++) {
                //we don't want weights that are bigger than the bag size.
                if (weights[j] <= w) {
                    int currValue = values[j];
                    int currWeight = weights[j];
                    dp[w] = Math.max(dp[w], currValue + dp[w - currWeight]);
                }
            }
        }
        return dp[weight];
    }

}
