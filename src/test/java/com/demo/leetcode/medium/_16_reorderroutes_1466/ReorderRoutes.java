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
 * - Set (edge), Map(Connections), computeIfAbsent, visited
 *
 *  PRACTICE
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
     */
    public int minReorder(int n, int[][] connections) {
        Set<String> edges = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] c : connections) {
            edges.add(c[0] + "," + c[1]);
            map.computeIfAbsent(c[0], k -> new HashSet<>());
            map.computeIfAbsent(c[1], k -> new HashSet<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(c[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int result = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int next : map.getOrDefault(c, new HashSet<>())) {
                //if visited skip
                if (visited[next]) continue;
                //mark as visited
                visited[next] = true;
                //set doesnt contain the edge.
                if (!edges.contains(next + "," + c)) result++;
                q.offer(next);
            }
        }
        return result;
    }
}
