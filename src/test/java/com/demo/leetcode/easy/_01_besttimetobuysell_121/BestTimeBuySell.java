package com.demo.leetcode.easy._01_besttimetobuysell_121;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [121. Best Time to Buy and Sell Stock - EASY](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 *
 * - kadane
 * - SIMILAR_TO: [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=1pkOgXD63yU&ab_channel=NeetCode
 */
public class BestTimeBuySell {

    @Test
    public void test() {
        int[] arr = {7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, maxProfit(arr));
        Assertions.assertEquals(5, maxProfitTwoPointer(arr));
    }

    /**
     * This will handle negative values as well.
     * Similar to max subarray problem.
     *
     * Kadane's Algorithm
     */
    public int maxProfit(int[] prices) {
        int currSum = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += (prices[i] - prices[i - 1]);
            maxSoFar = Math.max(currSum, maxSoFar);
        }
        return maxSoFar;
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
            if (prices[left] < prices[right])
                maxProfit = Math.max(prices[right] - prices[left], maxProfit);
            else
                left = right;
        }
        return maxProfit;
    }

}
