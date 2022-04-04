package com.demo.leetcode.easy._09_mincostclimbstairs_746;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [746. Min Cost Climbing Stairs - EASY](https://leetcode.com/problems/min-cost-climbing-stairs/)
 *
 * - dp
 * - SIMILAR_TO: [70. Climbing Stairs - EASY](https://leetcode.com/problems/climbing-stairs/)
 *
 * https://www.youtube.com/watch?v=ktmzAZWkEZ0&ab_channel=NeetCode
 */
public class MinCostClimbStairs {

    @Test
    public void test1() {
        int[] cost = {10, 15, 20};
        Assertions.assertEquals(15, minCostClimbingStairs(cost));
    }

    @Test
    public void test2() {
        int[] cost = {10, 15};
        Assertions.assertEquals(10, minCostClimbingStairs(cost));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
