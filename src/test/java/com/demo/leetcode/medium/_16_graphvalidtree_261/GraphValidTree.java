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
 * - https://www.lintcode.com/problem/178/
 * - bfs
 * - SIMILAR_TO: [1466. Reorder Routes to Make All Paths Lead to the City Zero - MEDIUM](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)
 * - PRACTICE: P1
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
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 2}};
        Assertions.assertFalse(validTree(n, edges));
    }

    @Test
    public void test4() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {4, 0}};
        Assertions.assertFalse(validTree(n, edges));
    }

    @Test
    public void test5() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {2, 1}, {3, 4}};
        Assertions.assertFalse(validTree(n, edges));
    }

    /**
     * Time: O(E+V)
     * Space: O(E+V)
     */
    public boolean validTree(int n, int[][] edges) {
        //If edge are more than nodes - 1 then loops present
        if (n == 0 || edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyMap.putIfAbsent(i, new HashSet<>());
        }
        //adjacency list
        for (int[] c : edges) {
            adjacencyMap.get(c[0]).add(c[1]);
            adjacencyMap.get(c[1]).add(c[0]);
        }
        //below code checks if node is connected.
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : adjacencyMap.get(parent))
                if (!visited.contains(child)) {
                    queue.offer(child);
                    visited.add(child);
                }
        }
        return visited.size() == n;
    }
}
