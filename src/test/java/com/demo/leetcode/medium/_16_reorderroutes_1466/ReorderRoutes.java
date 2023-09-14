package com.demo.leetcode.medium._16_reorderroutes_1466;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1466. Reorder Routes to Make All Paths Lead to the City Zero - MEDIUM](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)
 *
 * - bfs
 * - PRACTICE: P1
 *
 *  https://www.youtube.com/watch?v=m17yOR5_PpI&ab_channel=NeetCode
 */
public class ReorderRoutes {

    @Test
    public void test() {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        Assertions.assertEquals(3, minReorder(n, connections));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int minReorder(int n, int[][] connections) {
        Set<String> edgeSet = new HashSet<>();
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        for (int[] c : connections) {
            edgeSet.add(c[0] + "," + c[1]);
            adjacencyMap.putIfAbsent(c[0], new HashSet<>());
            adjacencyMap.putIfAbsent(c[1], new HashSet<>());
            //important to add both nodes in both adjacency list, even though input is uni directional edge.
            adjacencyMap.get(c[0]).add(c[1]);
            adjacencyMap.get(c[1]).add(c[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited.add(parent);
            for (int neighbour : adjacencyMap.get(parent)) {
                if (!visited.contains(neighbour)) {
                    //from parent to neighbour indicates outgoing edge
                    if (edgeSet.contains(parent + "," + neighbour)) {
                        result++;
                    }
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }
}
