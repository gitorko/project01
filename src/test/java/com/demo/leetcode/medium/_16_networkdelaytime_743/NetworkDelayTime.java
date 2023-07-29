package com.demo.leetcode.medium._16_networkdelaytime_743;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [743. Network Delay Time - MEDIUM](https://leetcode.com/problems/network-delay-time/)
 *
 * - dijkstra, shortest path
 * - bfs, min heap of cost, visited
 * - SIMILAR_TO: [1584. Min Cost to Connect All Points - MEDIUM](https://leetcode.com/problems/min-cost-to-connect-all-points/)
 * - SIMILAR_TO: [778. Swim in Rising Water - HARD](https://leetcode.com/problems/swim-in-rising-water/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=EaphyqKU4PQ&ab_channel=NeetCode
 */
public class NetworkDelayTime {

    @Test
    public void test1() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        Assertions.assertEquals(2, networkDelayTime(times, n, k));
    }

    @Test
    public void test2() {
        int[][] times = {{1, 2, 4}, {1, 3, 1}, {3, 4, 1}, {4, 2, 1}};
        int n = 4, k = 1;
        Assertions.assertEquals(3, networkDelayTime(times, n, k));
    }

    /**
     * Time: O(e * log(v)) , where v is nodes, e is edges
     * Space: O(v + e)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        //[source, target, cost]
        Map<Integer, Map<Integer, Integer>> adjacencyMap = new HashMap<>();
        //adjacency map
        for (int[] time : times) {
            adjacencyMap.putIfAbsent(time[0], new HashMap<>());
            adjacencyMap.get(time[0]).put(time[1], time[2]);
        }
        //[cost, node]
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        minHeap.add(new int[]{0, k});
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curCost = cur[0];
            int curNode = cur[1];
            if (visited.contains(curNode)) {
                continue;
            }
            // add neighbours
            if (adjacencyMap.containsKey(curNode)) {
                for (Map.Entry<Integer, Integer> next : adjacencyMap.get(curNode).entrySet()) {
                    minHeap.add(new int[]{curCost + next.getValue(), next.getKey()});
                }
            }
            // add to visited
            visited.add(curNode);
            result = curCost;
        }
        return visited.size() == n ? result : -1;
    }
}
