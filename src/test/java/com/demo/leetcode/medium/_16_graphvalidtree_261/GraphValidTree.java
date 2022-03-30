package com.demo.leetcode.medium._16_graphvalidtree_261;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [261. Graph Valid Tree - MEDIUM](https://leetcode.com/problems/graph-valid-tree/)
 *
 * - dfs
 * - SIMILAR_TO: [1466. Reorder Routes to Make All Paths Lead to the City Zero - MEDIUM](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)
 *
 * https://www.youtube.com/watch?v=bXsUuownnoQ&ab_channel=NeetCode
 */
public class GraphValidTree {

    @Test
    public void test1() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        Assertions.assertTrue(validTree(n, edges));
    }

    @Test
    public void test2() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {4, 2}};
        Assertions.assertFalse(validTree(n, edges));
    }

    @Test
    public void test3() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {4, 2}};
        Assertions.assertFalse(validTree(n, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        //for connected graph of n nodes it should have n-1 edges
        if (n == 0 || edges.length != n - 1)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        seen.add(0);
        queue.add(0);

        for (int i = 0; i < n; ++i)
            adjacencyMap.computeIfAbsent(i, k -> new HashSet<>());

        //adjacency list
        for (int[] c : edges) {
            adjacencyMap.get(c[0]).add(c[1]);
            adjacencyMap.get(c[1]).add(c[0]);
        }

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : adjacencyMap.get(parent))
                if (!seen.contains(child)) {
                    queue.offer(child);
                    seen.add(child);
                }
        }
        return seen.size() == n;
    }
}
