package com.demo.leetcode.medium._16_connectedcomponents_323;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [323. Number of Connected Components in an Undirected Graph - MEDIUM](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
 *
 * - dfs
 * - SIMILAR_TO: [261. Graph Valid Tree - MEDIUM](https://leetcode.com/problems/graph-valid-tree/)
 * - SIMILAR_TO: [547. Number of Provinces - MEDIUM](https://leetcode.com/problems/number-of-provinces/)
 *
 * https://www.youtube.com/watch?v=8f1XPm4WOUc&ab_channel=NeetCode
 */
public class ConnectedComponents {

    @Test
    public void test() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        Assertions.assertEquals(2, countComponents(n, edges));
    }

    /**
     * Time: O(∣V∣+∣E∣)
     * Space: O(∣V∣+∣E∣)
     */
    Set<Integer> seen;
    Map<Integer, Set<Integer>> adjacencyMap;

    public int countComponents(int n, int[][] edges) {
        adjacencyMap = new HashMap<>();
        seen = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; ++i)
            adjacencyMap.computeIfAbsent(i, k -> new HashSet<>());

        //adjacency list
        for (int[] c : edges) {
            adjacencyMap.get(c[0]).add(c[1]);
            adjacencyMap.get(c[1]).add(c[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                seen.add(i);
                dfs(i);
                result++;
            }
        }
        return result;
    }

    private void dfs(int parent) {
        for (int child : adjacencyMap.get(parent)) {
            if (!seen.contains(child)) {
                seen.add(child);
                dfs(child);
            }
        }
    }
}
