package com.demo.leetcode.medium._06_numberofislands_200;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [200. Number of Islands - MEDIUM](https://leetcode.com/problems/number-of-islands/)
 *
 * - dfs
 * - no need of visited, use same grid mark as '0'
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
    int rowLen;
    int colLen;
    char[][] grid;

    public int numIslands(char[][] input) {
        this.grid = input;
        int count = 0;
        rowLen = grid.length;
        colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] != '1')
            return;
        //prevent land cells from being traversed and counted more than once.
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
