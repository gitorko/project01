package com.demo.leetcode.hard._35_longestIncreasingpathmatrix_329;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [329. Longest Increasing Path in a Matrix - HARD](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
 *
 * - dfs
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
    int n;
    int m;
    int[][] cache;

    public int longestIncreasingPath(int[][] input) {
        this.matrix = input;
        this.m = matrix.length;
        this.n = matrix[0].length;

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, null));
            }
        }
        return max;
    }

    private int dfs(int i, int j, Integer prev) {
        if (i < 0 || i >= m || j < 0 || j >= n || prev != null && prev >= matrix[i][j])
            return 0;

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int a = dfs(i + 1, j, matrix[i][j]);
        int b = dfs(i - 1, j, matrix[i][j]);
        int c = dfs(i, j - 1, matrix[i][j]);
        int d = dfs(i, j + 1, matrix[i][j]);
        cache[i][j] = Math.max(Math.max(a, b), Math.max(c, d)) + 1;
        return cache[i][j];
    }
}
