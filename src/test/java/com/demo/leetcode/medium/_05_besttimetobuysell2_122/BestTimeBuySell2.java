package com.demo.leetcode.medium._05_besttimetobuysell2_122;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [122. Best Time to Buy and Sell Stock II - MEDIUM](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
 *
 * - compare to previous
 *
 * https://www.youtube.com/watch?v=3SJ3pUkPQMc&ab_channel=NeetCode
 */
public class BestTimeBuySell2 {

    @Test
    public void test() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(7, maxProfit(arr));
    }

    /**
     * one pass
     * Time: O(N)
     * Space: O(1)
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        //start from 2nd and compare to previous
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
