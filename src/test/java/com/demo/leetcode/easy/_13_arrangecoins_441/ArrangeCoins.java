package com.demo.leetcode.easy._13_arrangecoins_441;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [441. Arranging Coins - EASY](https://leetcode.com/problems/arranging-coins/)
 *
 * - binary search, gauss formula (n*(n+1))/2
 * - use long to avoid overflow
 *
 * https://www.youtube.com/watch?v=5rHz_6s2Buw&ab_channel=NeetCode
 */
public class ArrangeCoins {

    @Test
    public void test() {
        Assertions.assertEquals(2, arrangeCoins(5));
    }

    /**
     * Time: O(log(n))
     * Space: O(1).
     */
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            //gauss = (n*(n+1))/2
            long coins = (mid * (mid + 1)) / 2;
            if (coins == n) {
                return (int) mid;
            } else if (coins > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
