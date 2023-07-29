package com.demo.leetcode.easy._01_besttimetobuysell_121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [121. Best Time to Buy and Sell Stock - EASY](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 *
 * - kadane algorithm
 * - SIMILAR_TO: [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=1pkOgXD63yU&ab_channel=NeetCode
 */
public class BestTimeBuySell {

    @Test
    public void test1() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, maxProfit(arr));
        Assertions.assertEquals(5, maxProfitTwoPointer(arr));
    }

    @Test
    public void test2() {
        int[] arr = {7, 6, 4, 3, 1};
        Assertions.assertEquals(0, maxProfit(arr));
        Assertions.assertEquals(0, maxProfitTwoPointer(arr));
    }

    /**
     * This will handle negative values as well.
     * Kadane's Algorithm
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        //start from 2nd price
        for (int i = 1; i < prices.length; i++) {
            if (profit < 0) {
                profit = 0;
            }
            profit += (prices[i] - prices[i - 1]);
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    /**
     * Two pointer approach, if we want the day when to buy/sell
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxProfitTwoPointer(int prices[]) {
        int maxProfit = 0;
        int left = 0;
        for (int right = 1; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
        }
        return maxProfit;
    }

}
