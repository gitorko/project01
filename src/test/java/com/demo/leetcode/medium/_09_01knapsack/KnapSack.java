package com.demo.leetcode.medium._09_01knapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [0/1 knapsack - MEDIUM]()
 *
 * - SIMILAR_TO: [Unbounded knapsack - MEDIUM]()
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=8LusJS5-AGo&ab_channel=TusharRoy-CodingMadeSimple
 */
public class KnapSack {

    @Test
    public void test1() {
        int weight = 7;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        Assertions.assertEquals(9, knapSack(weight, weights, values));
        Assertions.assertEquals(9, knapSack2(weight, weights, values));
    }

    @Test
    public void test2() {
        int weight = 90;
        int[] weights = {30, 40, 60};
        int[] values = {3, 4, 5};
        Assertions.assertEquals(8, knapSack(weight, weights, values));
        Assertions.assertEquals(8, knapSack2(weight, weights, values));
    }

    /**
     * Extra space we store full table
     * Space: O(n * w)
     */
    public int knapSack(int weight, int[] weights, int[] values) {
        int[][] dp = new int[values.length + 1][weight + 1];
        //first row in dp is zero row, hence start from 1
        for (int i = 1; i < values.length + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                int currValue = values[i - 1];
                int currWeight = weights[i - 1];
                if (j - currWeight >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], currValue + dp[i - 1][j - currWeight]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[values.length][weight];
    }

    /**
     * Uses less space as it stores only one previous row.
     * Time: O(n*weights)
     * Space: O(weights)
     */
    public int knapSack2(int weight, int weights[], int values[]) {
        int dp[] = new int[weight + 1];
        for (int i = 1; i < values.length + 1; i++) {
            for (int j = weight; j >= weights[i - 1]; j--) {
                //since array start from 0, we have to do (i - 1);
                int currValue = values[i - 1];
                int currWeight = weights[i - 1];
                dp[j] = Math.max(dp[j], currValue + dp[j - currWeight]);
            }
        }
        return dp[weight];
    }

}
