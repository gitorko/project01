package com.demo.leetcode.medium._06_countsubislands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1905. Count Sub Islands - MEDIUM](https://leetcode.com/problems/count-sub-islands/)
 *
 * - single and
 *
 * https://www.youtube.com/watch?v=mLpW3qfbNJ8&ab_channel=NeetCode
 */
public class CountSubIslands {

    @Test
    public void test() {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        Assertions.assertEquals(3, countSubIslands(grid1, grid2));
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    int[][] grid1;
    int[][] grid2;
    int rowLen;
    int colLen;

    public int countSubIslands(int[][] input1, int[][] input2) {
        grid1 = input1;
        grid2 = input2;
        rowLen = grid2.length;
        colLen = grid2[0].length;

        int result = 0;
        for (int i = 0; i < rowLen; i++)
            for (int j = 0; j < colLen; j++)
                if (grid2[i][j] == 1)
                    result += dfs(i, j);
        return result;
    }

    //will always return 1 or 0
    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i == rowLen || j == colLen || grid2[i][j] != 1)
            return 1;
        // mark 2 as visited
        grid2[i][j] = 2;

        return dfs(i + 1, j) &
                dfs(i - 1, j) &
                dfs(i, j + 1) &
                dfs(i, j - 1) &
                grid1[i][j];
    }
}
