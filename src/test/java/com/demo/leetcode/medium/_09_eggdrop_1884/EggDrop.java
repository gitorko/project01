package com.demo.leetcode.medium._09_eggdrop_1884;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Egg Drop - MEDIUM]()
 *
 * - dp
 */
public class EggDrop {

    @Test
    public void test() {
        Assertions.assertEquals(2, twoEggDrop(2));
        Assertions.assertEquals(14, twoEggDrop(100));
    }

    int[][] dp;

    public int twoEggDrop(int n) {
        int eggs = 2;
        dp = new int[n + 1][eggs + 1];
        return drop(n, eggs);
    }

    int drop(int floors, int eggs) {
        if (eggs == 1 || floors <= 1)
            return floors;
        if (dp[floors][eggs] > 0)
            return dp[floors][eggs];
        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= floors; f++)
            min = Math.min(min, 1 + Math.max(drop(f - 1, eggs - 1), drop(floors - f, eggs)));
        dp[floors][eggs] = min;
        return min;
    }
}
