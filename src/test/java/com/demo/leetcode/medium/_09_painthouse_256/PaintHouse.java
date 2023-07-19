package com.demo.leetcode.medium._09_painthouse_256;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [256. Paint House - MEDIUM](https://leetcode.com/problems/paint-house/)
 *
 * - https://www.lintcode.com/problem/515/
 * - dp
 *
 * https://www.youtube.com/watch?v=-w67-4tnH5U&ab_channel=NeetCode
 */
public class PaintHouse {

    @Test
    public void test1() {
        int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        Assertions.assertEquals(10, minCost(costs));
    }

    @Test
    public void test2() {
        int[][] costs = {{1, 2, 3}};
        Assertions.assertEquals(1, minCost(costs));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[] dp = new int[costs[0].length];
        for (int i = 0; i < costs.length; i++) {
            int dp0 = costs[i][0] + Math.min(dp[1], dp[2]);
            int dp1 = costs[i][1] + Math.min(dp[0], dp[2]);
            int dp2 = costs[i][2] + Math.min(dp[0], dp[1]);
            dp = new int[]{dp0, dp1, dp2};
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
