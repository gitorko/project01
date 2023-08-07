package com.demo.leetcode.medium._16_minfueltocapital_2477;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2477. Minimum Fuel Cost to Report to the Capital - MEDIUM](https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/)
 *
 * https://www.youtube.com/watch?v=I3lnDUIzIG4&t=73s&ab_channel=NeetCodeIO
 */
public class MinFuelToCapital {

    @Test
    public void test() {
        int[][] roads = {{0, 1}, {0, 2}, {0, 3}};
        int seats = 5;
        Assertions.assertEquals(3, minimumFuelCost(roads, seats));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    Map<Integer, List<Integer>> adjacencyGraph;
    int seats;
    long result = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        adjacencyGraph = new HashMap<>();
        this.seats = seats;
        for (int[] road : roads) {
            adjacencyGraph.putIfAbsent(road[0], new ArrayList<>());
            adjacencyGraph.putIfAbsent(road[1], new ArrayList<>());
            adjacencyGraph.get(road[0]).add(road[1]);
            adjacencyGraph.get(road[1]).add(road[0]);
        }
        dfs(0, -1);
        return result;
    }

    private int dfs(int curr, int prev) {
        int people = 1;
        for (int neighbour : adjacencyGraph.getOrDefault(curr, Collections.emptyList())) {
            if (neighbour == prev) {
                continue;
            }
            people += dfs(neighbour, curr);
        }
        if (curr > 0) {
            // # of cars needed = ceil(people / seats)
            result += (people + seats - 1) / seats;
        }
        return people;
    }
}
