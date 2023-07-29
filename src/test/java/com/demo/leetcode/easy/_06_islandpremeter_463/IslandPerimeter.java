package com.demo.leetcode.easy._06_islandpremeter_463;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [463. Island Perimeter - EASY](https://leetcode.com/problems/island-perimeter/)
 *
 * - dfs, set to -1 for already visited
 * - edge case to return 0 when grid[i][j] is -1
 * - SIMILAR_TO: [200. Number of Islands - MEDIUM](https://leetcode.com/problems/number-of-islands/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=fISIuAFRM2s&ab_channel=NeetCode
 */
public class IslandPerimeter {

    @Test
    public void test() {
        int grid[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Assertions.assertEquals(16, islandPerimeter(grid));
    }

    /**
     * Time: O(m*n)
     * Space: O(1) (as we modify input)
     */
    int rowLen;
    int colLen;

    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        rowLen = grid.length;
        colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] == 0) {
            return 1;
        }
        //return if edge is -1 as already processed.
        if (grid[i][j] == -1) {
            return 0;
        }
        //set to -1 so that we don't count the perimeter, if we set to 0 then it will add to perimeter.
        grid[i][j] = -1;
        int count = 0;
        count += dfs(i - 1, j, grid);
        count += dfs(i, j - 1, grid);
        count += dfs(i + 1, j, grid);
        count += dfs(i, j + 1, grid);
        return count;
    }
}
