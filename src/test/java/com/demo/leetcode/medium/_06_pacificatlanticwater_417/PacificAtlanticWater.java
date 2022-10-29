package com.demo.leetcode.medium._06_pacificatlanticwater_417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [417. Pacific Atlantic Water Flow - MEDIUM](https://leetcode.com/problems/pacific-atlantic-water-flow/)
 *
 * - height is 0.
 * - dfs from first row, last row, first column, last column
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=s-VkcjHqkGI&ab_channel=NeetCode
 */
public class PacificAtlanticWater {

    @Test
    public void test() {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0, 4), Arrays.asList(1, 3), Arrays.asList(1, 4), Arrays.asList(2, 2),
                Arrays.asList(3, 0), Arrays.asList(3, 1), Arrays.asList(4, 0));
        Assertions.assertEquals(expected, pacificAtlantic(heights));
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    int[][] heights;
    int rowLen;
    int colLen;

    public List<List<Integer>> pacificAtlantic(int[][] input) {
        heights = input;
        rowLen = heights.length;
        colLen = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visitedP = new boolean[rowLen][colLen];
        boolean[][] visitedA = new boolean[rowLen][colLen];

        //first column, last column, height is 0 as it can flow to ocean
        for (int i = 0; i < rowLen; i++) {
            dfs(i, 0, 0, visitedP);
            dfs(i, colLen - 1, 0, visitedA);
        }

        //first row, last row, height is 0 as it can flow to ocean
        for (int j = 0; j < colLen; j++) {
            dfs(0, j, 0, visitedP);
            dfs(rowLen - 1, j, 0, visitedA);
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int h, boolean[][] visited) {
        if (i < 0 || j < 0 || i == rowLen || j == colLen || visited[i][j] || heights[i][j] < h) {
            return;
        }

        visited[i][j] = true;
        dfs(i + 1, j, heights[i][j], visited);
        dfs(i - 1, j, heights[i][j], visited);
        dfs(i, j + 1, heights[i][j], visited);
        dfs(i, j - 1, heights[i][j], visited);
    }
}
