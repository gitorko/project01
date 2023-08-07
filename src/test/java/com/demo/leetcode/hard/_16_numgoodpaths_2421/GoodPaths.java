package com.demo.leetcode.hard._16_numgoodpaths_2421;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2421. Number of Good Paths - HARD](https://leetcode.com/problems/number-of-good-paths/)
 *
 * - union find
 * - SIMILAR_TO: [323. Number of Connected Components in an Undirected Graph - MEDIUM](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
 *
 * https://www.youtube.com/watch?v=rv2GBYQm7xM&ab_channel=NeetCodeIO
 */
public class GoodPaths {

    @Test
    public void test() {
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        Assertions.assertEquals(6, numberOfGoodPaths(vals, edges));
    }

    /**
     * Time: O(n * log(n))
     */
    int[] parent;
    int[] rank;
    //[parent, child]
    Map<Integer, List<Integer>> adjacencyMap;
    //[value, index]
    Map<Integer, List<Integer>> valMap;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int result = 0;
        this.adjacencyMap = new HashMap<>();
        this.valMap = new TreeMap<>();
        this.parent = new int[vals.length];
        this.rank = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        //add values
        for (int i = 0; i < vals.length; i++) {
            adjacencyMap.putIfAbsent(i, new ArrayList<>());
            valMap.putIfAbsent(vals[i], new ArrayList<>());
            valMap.get(vals[i]).add(i);
        }
        //adjacency graph
        for (int[] edge : edges) {
            if (vals[edge[0]] >= vals[edge[1]]) {
                adjacencyMap.putIfAbsent(edge[0], new ArrayList<>());
                adjacencyMap.get(edge[0]).add(edge[1]);
            } else {
                adjacencyMap.putIfAbsent(edge[1], new ArrayList<>());
                adjacencyMap.get(edge[1]).add(edge[0]);
            }
        }

        for (Integer val : valMap.keySet()) {
            for (Integer node : valMap.get(val)) {
                for (Integer neighbour : adjacencyMap.get(node)) {
                    union(node, neighbour);
                }
            }
            HashMap<Integer, Integer> group = new HashMap<>();
            for (Integer node : valMap.get(val)) {
                int parent = findParent(node);
                group.put(parent, group.getOrDefault(parent, 0) + 1);
                result += group.get(parent);
            }
        }
        return result;
    }

    private int findParent(int n) {
        int result = parent[n];
        while (result != parent[result]) {
            result = parent[result];
        }
        return result;
    }

    private int union(int n1, int n2) {
        int p1 = findParent(n1);
        int p2 = findParent(n2);
        //if parent same then they are already connected
        if (p1 == p2) {
            return 0;
        }
        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return 1;
    }
}
