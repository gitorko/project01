package com.demo.leetcode.hard._16_largestcolordg_1857;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1857. Largest Color Value in a Directed Graph - HARD](https://leetcode.com/problems/largest-color-value-in-a-directed-graph/)
 *
 * - DFS
 *
 * https://www.youtube.com/watch?v=xLoDjKczUSk&ab_channel=NeetCodeIO
 */
public class LargestColorGraph {

    @Test
    public void test() {
        String colors = "abaca";
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        Assertions.assertEquals(3, largestPathValue(colors, edges));
    }

    List<List<Integer>> adjGraph;
    int[][] dp;
    String colors;
    int[][] edges;
    Set<Integer> visited;
    Set<Integer> path;

    /**
     * Time: O(m + n)
     */
    public int largestPathValue(String colors, int[][] edges) {
        this.colors = colors;
        this.edges = edges;
        int n = colors.length();
        //[node, color]
        dp = new int[n][26];
        adjGraph = new ArrayList<>();
        visited = new HashSet<>();
        path = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            adjGraph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjGraph.get(e[0]).add(e[1]);
        }
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (!dfs(i)) {
                //cycle present in graph
                return -1;
            }
            for (int x : dp[i]) {
                result = Math.max(result, x);
            }
        }
        return result;
    }

    private boolean dfs(int node) {
        //Cycle detected if path already has the node
        if (path.contains(node)) {
            return false;
        }

        if (visited.contains(node)) {
            return true;
        }

        path.add(node);
        visited.add(node);

        for (int neighbour : adjGraph.get(node)) {
            if (!dfs(neighbour)) {
                return false;
            }
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbour][c]);
            }
        }
        dp[node][colors.charAt(node) - 'a']++;

        path.remove(node);
        return true;
    }
}
