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
 * - minimum spanning tree, prims algorithm
 * - min heap
 * - SIMILAR_TO: [743. Network Delay Time - MEDIUM](https://leetcode.com/problems/network-delay-time/)
 * - PRACTICE: P1
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
        int n = points.length;
        //[node1, node2, distance]
        Map<Integer, Map<Integer, Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacencyMap.putIfAbsent(i, new HashMap<>());
        }
        //adjacency list, every point connected to all points. O(n^2)
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjacencyMap.get(i).put(j, dist);
                adjacencyMap.get(j).put(i, dist);
            }
        }
        //[distance, point]
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        minHeap.add(new int[]{0, 0});
        //loop till all nodes are not visited
        while (visited.size() < n) {
            int[] cur = minHeap.poll();
            int cost = cur[0];
            int point = cur[1];
            if (visited.contains(point)) {
                continue;
            }
            visited.add(point);
            result += cost;
            for (Map.Entry<Integer, Integer> next : adjacencyMap.get(point).entrySet()) {
                if (!visited.contains(next.getKey())) {
                    //[cost, point]
                    minHeap.add(new int[]{next.getValue(), next.getKey()});
                }

            }
        }
        return result;
    }
}
