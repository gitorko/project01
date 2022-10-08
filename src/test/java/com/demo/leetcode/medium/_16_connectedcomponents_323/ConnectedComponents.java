package com.demo.leetcode.medium._16_connectedcomponents_323;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [323. Number of Connected Components in an Undirected Graph - MEDIUM](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
 *
 * - dfs or union find
 * - SIMILAR_TO: [261. Graph Valid Tree - MEDIUM](https://leetcode.com/problems/graph-valid-tree/)
 * - SIMILAR_TO: [547. Number of Provinces - MEDIUM](https://leetcode.com/problems/number-of-provinces/)
 * - SIMILAR_TO: [684. Redundant Connection - MEDIUM](https://leetcode.com/problems/redundant-connection/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=8f1XPm4WOUc&ab_channel=NeetCode
 */
public class ConnectedComponents {

    @Test
    public void test() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        Assertions.assertEquals(2, countComponents(n, edges));
        Assertions.assertEquals(2, countComponents2(n, edges));
    }

    /**
     * DFS
     * Time: O(e + v)
     * Space: O(e + v)
     */
    Set<Integer> visited;
    Map<Integer, Set<Integer>> adjacencyMap;

    public int countComponents(int n, int[][] edges) {
        adjacencyMap = new HashMap<>();
        visited = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            adjacencyMap.putIfAbsent(i, new HashSet<>());
        }

        //adjacency list
        for (int[] c : edges) {
            adjacencyMap.get(c[0]).add(c[1]);
            adjacencyMap.get(c[1]).add(c[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                dfs(i);
                result++;
            }
        }
        return result;
    }

    private void dfs(int parent) {
        for (int child : adjacencyMap.get(parent)) {
            if (!visited.contains(child)) {
                visited.add(child);
                dfs(child);
            }
        }
    }

    /**
     * Union Find - forrest of tress
     */
    int[] parent;
    int[] rank;

    public int countComponents2(int n, int[][] edges) {
        this.parent = new int[n + 1];
        this.rank = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int result = n;
        for (int[] edge : edges) {
            result -= union(edge[0], edge[1]);
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
