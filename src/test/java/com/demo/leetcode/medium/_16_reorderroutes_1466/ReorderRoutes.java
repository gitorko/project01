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
 * - Set(edge), Map(connections), Set(visited)
 * - PRACTICE: P3
 * - MISTAKES: Will probably miss considering the visited set ending up in infinite loop
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
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int[] c : connections) {
            //set contains the edge for quick lookup
            edgeSet.add(c[0] + "," + c[1]);
            adjMap.putIfAbsent(c[0], new HashSet<>());
            adjMap.putIfAbsent(c[1], new HashSet<>());
            //important to add both nodes in both adjacency list.
            adjMap.get(c[0]).add(c[1]);
            adjMap.get(c[1]).add(c[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!q.isEmpty()) {
            int parent = q.poll();
            visited.add(parent);
            for (int neighbour : adjMap.get(parent)) {
                if (!visited.contains(neighbour)) {
                    if (edgeSet.contains(parent + "," + neighbour)) {
                        result++;
                    }
                    q.add(neighbour);
                }
            }
        }
        return result;
    }
}
