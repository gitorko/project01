package com.demo.leetcode.medium._09_rodcutting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Rod Cutting - MEDIUM]()
 *
 * - unbounded knapsack
 *
 * https://www.youtube.com/watch?v=nYJDp0Hj7M4&ab_channel=TECHDOSE
 * https://www.youtube.com/watch?v=IRwVmTmN6go&ab_channel=TusharRoy-CodingMadeSimple
 */
public class RodCutting {

    @Test
    public void test() {
        int[] prices = {1, 5, 8, 9};
        int rodLength = 4;
        Assertions.assertEquals(10, rodCutting(rodLength, prices));
        Assertions.assertEquals(10, rodCutting2(rodLength, prices));
    }

    /**
     * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
     * Determine the locations where the cuts are to be made for maximum profit.
     */
    public int rodCutting(int rodLength, int[] prices) {
        int dp[] = new int[prices.length + 1];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = i; j <= prices.length; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + prices[i - 1]);
            }
        }
        return dp[prices.length];
    }

    public int rodCutting2(int len, int prices[]) {
        if (len <= 0) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 0; i < len; i++) {
            int val = prices[i] + rodCutting2(len - i - 1, prices);
            maxValue = Math.max(maxValue, val);
        }
        return maxValue;
    }
}
