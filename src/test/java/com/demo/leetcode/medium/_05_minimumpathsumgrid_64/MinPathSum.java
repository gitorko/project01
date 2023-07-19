package com.demo.leetcode.medium._05_minimumpathsumgrid_64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [64. Minimum Path Sum - MEDIUM](https://leetcode.com/problems/minimum-path-sum/)
 *
 * - first row+col different, modify input
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=hwRWt-PH394&t=334s&ab_channel=DEEPTITALESRA
 * https://www.youtube.com/watch?v=pGMsrvt0fpk&ab_channel=NeetCode
 */
public class MinPathSum {

    @Test
    public void test() {
        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Assertions.assertEquals(7, minPathSum(grid));
    }

    /**
     * Time: O(m * n)
     * Space: O(1) - doesnt use extra memory
     */
    public int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0 && col != 0) {
                    //first row
                    grid[row][col] += grid[row][col - 1];
                } else if (row != 0 && col == 0) {
                    //first col
                    grid[row][col] += grid[row - 1][col];
                } else if (row != 0 && col != 0) {
                    grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
