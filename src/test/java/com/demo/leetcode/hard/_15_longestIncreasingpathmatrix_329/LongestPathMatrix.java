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
    int colLength;
    int rowLength;
    int[][] cache;

    public int longestIncreasingPath(int[][] input) {
        this.matrix = input;
        this.rowLength = matrix.length;
        this.colLength = matrix[0].length;

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        cache = new int[rowLength][colLength];
        int max = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                max = Math.max(max, dfs(i, j, null));
            }
        }
        return max;
    }

    private int dfs(int i, int j, Integer prev) {
        //out of bounds case
        if (i < 0 || i >= rowLength || j < 0 || j >= colLength || prev != null && prev >= matrix[i][j])
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
