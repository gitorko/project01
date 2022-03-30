package com.demo.leetcode.medium._09_besttimetobuysell3_309;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [309. Best Time to Buy and Sell Stock with Cooldown - MEDIUM](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
 *
 * - dp map + recursion + buying
 * - if buy i + 1
 * - if sell i + 2
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=I7j0F7AHpb8&ab_channel=NeetCode
 */
public class BestTimeBuySellCoolDown {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 0, 2};
        Assertions.assertEquals(3, maxProfit(arr));
        Assertions.assertEquals(3, maxProfit2(arr));
    }

    /**
     * Recursion with cache
     */
    Map<String, Integer> dp;
    int[] prices;

    public int maxProfit(int[] input) {
        prices = input;
        dp = new HashMap<>();
        return maxProfit(0, true);
    }

    public int maxProfit(int i, boolean buying) {
        //end case for recursion
        if (i >= prices.length)
            return 0;

        String key = i + "_" + buying;
        if (dp.get(key) != null) {
            return dp.get(key);
        }
        if (buying) {
            int buy = maxProfit(i + 1, !buying) - prices[i];
            int coolDown = maxProfit(i + 1, buying);
            dp.put(key, Math.max(buy, coolDown));
        } else {
            int sell = maxProfit(i + 2, !buying) + prices[i];
            int coolDown = maxProfit(i + 1, buying);
            dp.put(key, Math.max(sell, coolDown));
        }
        return dp.get(key);
    }

    /**
     * Iterative DP
     */
    public int maxProfit2(int[] prices) {
        int sell = 0;
        int prevSell = 0;
        int prevBuy;
        int buy = Integer.MIN_VALUE;

        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }

}
