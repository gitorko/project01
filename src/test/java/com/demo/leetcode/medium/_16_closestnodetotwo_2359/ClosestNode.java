package com.demo.leetcode.medium._16_closestnodetotwo_2359;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2359. Find Closest Node to Given Two Nodes - MEDIUM](https://leetcode.com/problems/find-closest-node-to-given-two-nodes/)
 *
 * https://www.youtube.com/watch?v=AZA8orksO4w&ab_channel=NeetCodeIO
 */
public class ClosestNode {

    @Test
    public void test1() {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        Assertions.assertEquals(2, closestMeetingNode(edges, node1, node2));
    }

    @Test
    public void test2() {
        int[] edges = {1, 2, -1};
        int node1 = 0;
        int node2 = 2;
        Assertions.assertEquals(2, closestMeetingNode(edges, node1, node2));
    }

    @Test
    public void test3() {
        int[] edges = {4, 4, 4, 5, 1, 2, 2};
        int node1 = 1;
        int node2 = 1;
        Assertions.assertEquals(1, closestMeetingNode(edges, node1, node2));
    }

    @Test
    public void test4() {
        int[] edges = {2, 0, 0};
        int node1 = 2;
        int node2 = 0;
        Assertions.assertEquals(0, closestMeetingNode(edges, node1, node2));
    }

    /**
     * Time:
     * Space:
     */
    Map<Integer, Set<Integer>> adjacencyMap;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        adjacencyMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            adjacencyMap.putIfAbsent(i, new HashSet<>());
            //don't add the edge if its -1
            if (edges[i] != -1) {
                adjacencyMap.get(i).add(edges[i]);
            }
        }
        Map<Integer, Integer> distMap1 = new HashMap<>();
        Map<Integer, Integer> distMap2 = new HashMap<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();
        //distance of node to itself is 0.
        distMap1.put(node1, 0);
        distMap2.put(node2, 0);
        dfs(node1, distMap1, visited1);
        dfs(node2, distMap2, visited2);
        int minDist = Integer.MAX_VALUE;
        int result = -1;
        //where i is the node
        for (int i = 0; i < edges.length; i++) {
            if (distMap1.containsKey(i) && distMap2.containsKey(i) && minDist > Math.max(distMap1.get(i), distMap2.get(i))) {
                minDist = Math.max(distMap1.get(i), distMap2.get(i));
                result = i;
            }
        }
        return result;
    }

    private void dfs(int node, Map<Integer, Integer> distMap, Set<Integer> visited) {
        visited.add(node);
        for (Integer neighbour : adjacencyMap.get(node)) {
            if (!visited.contains(neighbour)) {
                distMap.put(neighbour, distMap.getOrDefault(node, 0) + 1);
                dfs(neighbour, distMap, visited);
            }
        }
    }
}
