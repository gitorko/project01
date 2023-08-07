package com.demo.leetcode.medium._16_pathmaxprobability_1514;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1514. Path with Maximum Probability - MEDIUM](https://leetcode.com/problems/path-with-maximum-probability/)
 *
 * - dijkstra, shortest path
 * - SIMILAR_TO: [743. Network Delay Time - MEDIUM](https://leetcode.com/problems/network-delay-time/)
 *
 * https://www.youtube.com/watch?v=kPsDTGcrzGM&ab_channel=NeetCodeIO
 */
public class PathMaxProbability {

    @Test
    public void test() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        Assertions.assertEquals(0.25000, maxProbability(n, edges, succProb, start, end));
    }

    /**
     * Time: O(e * log(v)) , where v is nodes, e is edges
     * Space: O(v + e)
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //[source, target, cost]
        Map<Integer, Map<Integer, Double>> adjacencyMap = new HashMap<>();
        //adjacency map
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adjacencyMap.putIfAbsent(edge[0], new HashMap<>());
            adjacencyMap.putIfAbsent(edge[1], new HashMap<>());
            adjacencyMap.get(edge[0]).put(edge[1], succProb[i]);
            adjacencyMap.get(edge[1]).put(edge[0], succProb[i]);
        }
        //[cost, node]
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> ((int) ((b[0] - a[0]) * 1000000000)));
        Set<Integer> visited = new HashSet<>();
        maxHeap.add(new double[]{1.0, start});
        while (!maxHeap.isEmpty()) {
            double[] cur = maxHeap.poll();
            double curCost = cur[0];
            int curNode = (int) cur[1];
            if (visited.contains(curNode)) {
                continue;
            }
            if (curNode == end) {
                return curCost;
            }
            // add neighbours
            if (adjacencyMap.containsKey(curNode)) {
                for (Map.Entry<Integer, Double> next : adjacencyMap.get(curNode).entrySet()) {
                    maxHeap.add(new double[]{curCost * next.getValue(), next.getKey()});
                }
            }
            // add to visited
            visited.add(curNode);
        }
        return 0;
    }

}
