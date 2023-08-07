package com.demo.leetcode.medium._16_mintimecollectapple_1443;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1443. Minimum Time to Collect All Apples in a Tree - MEDIUM](https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/)
 *
 * - parent child to avoid cycle
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Xdt5Z583auM&ab_channel=NeetCodeIO
 */
public class MinTimeCollectApple {

    @Test
    public void test1() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        int n = 7;
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        Assertions.assertEquals(8, minTime(n, edges, hasApple));
    }

    @Test
    public void test2() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        int n = 7;
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        Assertions.assertEquals(8, minTime(n, edges, hasApple));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    Map<Integer, Set<Integer>> adjacencyMap;
    List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        adjacencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyMap.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            //adding bidirectional edges, so need to be aware of cycles
            adjacencyMap.get(edge[0]).add(edge[1]);
            adjacencyMap.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1);
    }

    private int dfs(int cur, int parent) {
        int time = 0;
        for (int neighbour : adjacencyMap.get(cur)) {
            // if the neighbor is the parent node, then we skip
            if (neighbour == parent) {
                continue;
            }
            time += dfs(neighbour, cur);
        }
        // If current node is not the root (0th) node,
        // and it has an apple or any of its descendant has
        // then we need to add 2 time for moving to and from it
        if (cur != 0 && (hasApple.get(cur) || time > 0)) {
            time += 2;
        }
        return time;
    }
}
