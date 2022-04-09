package com.demo.leetcode.medium._16_cheapflightkstop_787;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [787. Cheapest Flights Within K Stops - MEDIUM](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
 *
 * - bellman-ford
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=5eIK3zUdYmE&ab_channel=NeetCode
 */
public class CheapFlightKStop {

    @Test
    public void test() {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        Assertions.assertEquals(700, findCheapestPrice(n, flights, src, dst, k));
    }

    /**
     * Time: O(e*k)
     * Space: O(e*k)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] f : flights) {
                int curr = f[0];
                int next = f[1];
                int price = f[2];
                if (cost[curr] == Integer.MAX_VALUE)
                    continue;
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
