package com.demo.leetcode.medium._06_closedisland_1254;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1254. Number of Closed Islands - MEDIUM](https://leetcode.com/problems/number-of-closed-islands/)
 *
 * https://www.youtube.com/watch?v=X8k48xek8g8&ab_channel=NeetCodeIO
 */
public class ClosedIsland {

    @Test
    public void test() {
        int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}};
        Assertions.assertEquals(2, closedIsland(grid));
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) result++;
                }
            }
        }
        return result;
    }

    public boolean dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean valid = true;
        for (int[] d : dir) {
            valid = valid & dfs(grid, x + d[0], y + d[1]);
        }
        return valid;
    }

}
