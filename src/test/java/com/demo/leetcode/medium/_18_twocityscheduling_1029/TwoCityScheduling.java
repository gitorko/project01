package com.demo.leetcode.medium._18_twocityscheduling_1029;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1029. Two City Scheduling - MEDIUM](https://leetcode.com/problems/two-city-scheduling/)
 *
 * - greedy, sort
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=d-B_gk_gJtQ&ab_channel=NeetCode
 */
public class TwoCityScheduling {

    @Test
    public void test1() {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        Assertions.assertEquals(110, twoCitySchedCost(costs));
    }

    @Test
    public void test2() {
        int[][] costs = {{10, 100}, {10, 1000}, {50, 500}, {1, 100}};
        Assertions.assertEquals(260, twoCitySchedCost(costs));
    }

    @Test
    public void test3() {
        int[][] costs = {{10, 100}, {10, 1000}};
        Assertions.assertEquals(110, twoCitySchedCost(costs));
    }

    /**
     * Time: O(n * log(n))
     * Space: O(1)
     */
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int result = 0;
        // sort in descending order by the money saved if we fly a person to A instead of B
        Arrays.sort(costs, (n1, n2) -> (n2[1] - n2[0]) - (n1[1] - n1[0]));
        for (int i = 0; i < n; i++) {
            result += costs[i][0] + costs[i + n][1];
        }
        return result;
    }
}
