package com.demo.leetcode.medium._06_spiralmatrix_59;


import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [59. Spiral Matrix II - MEDIUM](https://leetcode.com/problems/spiral-matrix-ii/)
 *
 * - dfs, with direction, visited
 *
 * https://www.youtube.com/watch?v=RvLrWFBJ9fM&ab_channel=NeetCodeIO
 */
public class SpiralMatrix {

    @Test
    public void test() {
        int[][] matrix = generateMatrix(3);
        Assertions.assertEquals("[[1, 2, 3], [8, 9, 4], [7, 6, 5]]", Arrays.deepToString(matrix));
    }

    int[][] matrix;
    int sqr = 1;
    boolean[][] visited;

    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        visited = new boolean[matrix.length][matrix[0].length];
        dfs(0, 0, true);
        return matrix;
    }

    private void dfs(int i, int j, boolean rightDown) {
        //base case - if visited or out of boundary
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        matrix[i][j] = sqr;
        sqr += 1;
        if (rightDown) {
            dfs(i, j + 1, rightDown);
            dfs(i + 1, j, rightDown);
            dfs(i, j - 1, !rightDown);
        } else {
            dfs(i, j - 1, rightDown);
            dfs(i - 1, j, rightDown);
            dfs(i, j + 1, !rightDown);
        }
    }
}
