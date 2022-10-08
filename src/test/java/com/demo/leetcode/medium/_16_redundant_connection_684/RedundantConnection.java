package com.demo.leetcode.medium._16_redundant_connection_684;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [684. Redundant Connection - MEDIUM](https://leetcode.com/problems/redundant-connection/)
 *
 * - union find
 * - n nodes have n-1 edges without cycle
 * - SIMILAR_TO: [323. Number of Connected Components in an Undirected Graph - MEDIUM](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=FXWRE67PLL0&ab_channel=NeetCode
 */
public class RedundantConnection {

    @Test
    public void test1() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, findRedundantConnection(edges));
    }

    @Test
    public void test2() {
        int[][] edges = {{1, 5}, {3, 4}, {3, 5}, {4, 5}, {2, 4}};
        int[] expected = {4, 5};
        Assertions.assertArrayEquals(expected, findRedundantConnection(edges));
    }

    /**
     * Time: O(n)
     */
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }

    private int findParent(int n) {
        int result = parent[n];
        while (result != parent[result]) {
            result = parent[result];
        }
        return result;
    }

    private boolean union(int n1, int n2) {
        int p1 = findParent(n1);
        int p2 = findParent(n2);
        //if parent same then they are already connected
        if (p1 == p2) {
            return false;
        }
        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return true;
    }
}
