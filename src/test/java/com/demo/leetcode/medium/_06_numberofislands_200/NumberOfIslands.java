package com.demo.leetcode.medium._06_numberofislands_200;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [200. Number of Islands - MEDIUM](https://leetcode.com/problems/number-of-islands/)
 *
 * - dfs, marking visited
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=pV2kpPD66nE&ab_channel=NeetCode
 */
public class NumberOfIslands {

    @Test
    public void test() {
        char grid[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assertions.assertEquals(3, numIslands(grid));
    }

    /**
     * Alternately, we could set up a duplicate matrix to record this information at the cost of increasing
     * the space complexity from O(L) to O(M * N + L)
     */
    int rowLength;
    int colLength;

    public int numIslands(char[][] grid) {
        int count = 0;
        rowLength = grid.length;
        colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++)
            for (int j = 0; j < colLength; j++)
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= rowLength || j >= colLength || grid[i][j] != '1') return;
        //prevent land cells from being traversed and counted more than once.
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
