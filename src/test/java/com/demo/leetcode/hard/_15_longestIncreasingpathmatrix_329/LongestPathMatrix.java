package com.demo.leetcode.hard._15_longestIncreasingpathmatrix_329;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [329. Longest Increasing Path in a Matrix - HARD](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
 *
 * - dfs + cache
 * - prev integer
 *
 * https://www.youtube.com/watch?v=wCc_nd-GiEc&ab_channel=NeetCode
 */
public class LongestPathMatrix {

    @Test
    public void test() {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Assertions.assertEquals(4, longestIncreasingPath(matrix));
    }

    /**
     * Time: O(m*n)
     * Space: O(m*n)
     */
    int[][] matrix;
    int colLen;
    int rowLen;
    int[][] dp;

    public int longestIncreasingPath(int[][] input) {
        this.matrix = input;
        this.rowLen = matrix.length;
        this.colLen = matrix[0].length;
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        dp = new int[rowLen][colLen];
        int max = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                max = Math.max(max, dfs(i, j, -1));
            }
        }
        return max;
    }

    private int dfs(int i, int j, int prev) {
        //out of bounds case
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || prev != -1 && prev >= matrix[i][j]) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int a = dfs(i + 1, j, matrix[i][j]);
        int b = dfs(i - 1, j, matrix[i][j]);
        int c = dfs(i, j - 1, matrix[i][j]);
        int d = dfs(i, j + 1, matrix[i][j]);
        //from all 4 directions pick the one with max path
        dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d)) + 1;
        return dp[i][j];
    }
}
