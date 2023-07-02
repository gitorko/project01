package com.demo.leetcode.medium._06_maxareaisland_695;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [695. Max Area of Island - MEDIUM](https://leetcode.com/problems/max-area-of-island/)
 *
 * - dfs + modify input
 * - SIMILAR_TO: [200. Number of Islands - MEDIUM](https://leetcode.com/problems/number-of-islands/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=iJGr1OtmH0c&ab_channel=NeetCode
 */
public class MaxAreaIsland {

    @Test
    public void test() {
        int grid[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        Assertions.assertEquals(6, maxAreaOfIsland(grid));
    }

    /**
     * Time: O(n * m) where n and m are the lengths of the sides of the grid
     * Space: O(l) where l is the size of the largest island, representing the maximum recursion stack
     * Space is O(n * m + l) if we create an N * M matrix dp cache in order to not modify the input
     */
    int rowLen;
    int colLen;
    int[][] grid;

    public int maxAreaOfIsland(int[][] input) {
        grid = input;
        int result = 0;
        rowLen = grid.length;
        colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] > 0) {
                    result = Math.max(result, dfs(i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] < 1) {
            return 0;
        }
        //prevent land cells from being traversed and counted more than once.
        grid[i][j] = 0;
        return 1 + dfs(i - 1, j) + dfs(i, j - 1) + dfs(i + 1, j) + dfs(i, j + 1);
    }
}
