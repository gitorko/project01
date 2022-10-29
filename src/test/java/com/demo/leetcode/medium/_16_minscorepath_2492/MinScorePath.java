package com.demo.leetcode.medium._16_minscorepath_2492;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2492. Minimum Score of a Path Between Two Cities - MEDIUM](https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/)
 *
 * - dfs
 *
 * https://www.youtube.com/watch?v=K7-mXA0irhY&ab_channel=NeetCodeIO
 */
public class MinScorePath {

    @Test
    public void test() {
        int n = 4;
        //[source, destination, cost]
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        Assertions.assertEquals(5, minScore(n, roads));
    }

    int min;

    /**
     * Time: O(E+V)
     */
    public int minScore(int n, int[][] roads) {
        //[destination, cost]
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adjacencyList.get(roads[i][0] - 1).add(new int[]{roads[i][1] - 1, roads[i][2]});
            adjacencyList.get(roads[i][1] - 1).add(new int[]{roads[i][0] - 1, roads[i][2]});
        }
        min = Integer.MAX_VALUE;
        boolean visited[] = new boolean[n];
        dfs(adjacencyList, visited, 0);
        if (visited[n - 1]) {
            return min;
        }
        return -1;
    }

    private void dfs(List<List<int[]>> graph, boolean visited[], int s) {
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        for (int[] child : graph.get(s)) {
            dfs(graph, visited, child[0]);
            min = Math.min(min, child[1]);
        }
    }
}
