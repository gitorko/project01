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
    int rowLength;
    int colLength;

    public List<List<Integer>> pacificAtlantic(int[][] input) {
        heights = input;
        rowLength = heights.length;
        colLength = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] seenP = new boolean[rowLength][colLength];
        boolean[][] seenA = new boolean[rowLength][colLength];

        //first column, last column, height is 0 as it can flow to ocean
        for (int i = 0; i < rowLength; i++) {
            dfs(i, 0, 0, seenP);
            dfs(i, colLength - 1, 0, seenA);
        }

        //first row, last row, height is 0 as it can flow to ocean
        for (int j = 0; j < colLength; j++) {
            dfs(0, j, 0, seenP);
            dfs(rowLength - 1, j, 0, seenA);
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (seenP[i][j] && seenA[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int h, boolean[][] seen) {
        if (i < 0 || j < 0 || i == rowLength || j == colLength || seen[i][j] || heights[i][j] < h)
            return;

        seen[i][j] = true;
        dfs(i + 1, j, heights[i][j], seen);
        dfs(i - 1, j, heights[i][j], seen);
        dfs(i, j + 1, heights[i][j], seen);
        dfs(i, j - 1, heights[i][j], seen);
    }
}
