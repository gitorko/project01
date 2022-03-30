package com.demo.leetcode.medium._16_minspanningtree_1584;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1584. Min Cost to Connect All Points - MEDIUM](https://leetcode.com/problems/min-cost-to-connect-all-points/)
 *
 * - prim algo
 * - SIMILAR_TO: [743. Network Delay Time - MEDIUM](https://leetcode.com/problems/network-delay-time/)
 *
 * https://www.youtube.com/watch?v=f7JOBJIC-NA&ab_channel=NeetCode
 */
public class MinSpanningTree {

    @Test
    public void test1() {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        Assertions.assertEquals(20, minCostConnectPoints(points));
    }

    /**
     * Time: O(n^2 log(n))
     * Space: O(n + e)
     */
    public int minCostConnectPoints(int[][] points) {
        int pointLen = points.length;
        //[node1, node2, cost]
        Map<Integer, Map<Integer, Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < pointLen; i++)
            adjacencyMap.computeIfAbsent(i, m -> new HashMap<>());

        //adjacency list
        for (int i = 0; i < pointLen; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < pointLen; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjacencyMap.get(i).put(j, dist);
                adjacencyMap.get(j).put(i, dist);
            }
        }

        //[cost, point]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        pq.add(new int[]{0, 0});

        while (visited.size() < pointLen) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int point = cur[1];
            if (visited.contains(point))
                continue;

            visited.add(point);
            result += cost;
            for (Map.Entry<Integer, Integer> next : adjacencyMap.get(point).entrySet()) {
                if (!visited.contains(next.getKey())) {
                    //[cost, point]
                    pq.add(new int[]{next.getValue(), next.getKey()});
                }

            }
        }
        return result;
    }
}
