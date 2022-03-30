package com.demo.leetcode.medium._09_uniquepath2_63;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [63. Unique Paths II - MEDIUM](https://leetcode.com/problems/unique-paths-ii/)
 *
 * - fill last row,col, obstacle
 * - obstacle on last cell
 */
public class UniquePath2 {

    @Test
    public void test() {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Assertions.assertEquals(2, uniquePathsWithObstacles(grid));
    }

    @Test
    public void test2() {
        int[][] grid = {{0, 0}, {1, 1}, {0, 0, 0}};
        Assertions.assertEquals(0, uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;

        //edge case - obstacle on last path.
        if (obstacleGrid[rowLen - 1][colLen - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[rowLen][colLen];

        //Fill last column - remember to iterate from last.
        for (int j = colLen - 1; j >= 0; j--) {
            if (obstacleGrid[rowLen - 1][j] == 1) {
                break;
            }
            dp[rowLen - 1][j] = 1;
        }

        //Fill last rowLen - remember to iterate from last.
        for (int i = rowLen - 1; i >= 0; i--) {
            if (obstacleGrid[i][colLen - 1] == 1) {
                break;
            }
            dp[i][colLen - 1] = 1;
        }

        //Last rowLen and column are already filled so skip them
        for (int i = rowLen - 2; i >= 0; i--) {
            for (int j = colLen - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

}
