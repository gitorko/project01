package com.demo.leetcode.medium._06_spiralmatrix_54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [54. Spiral Matrix - MEDIUM](https://leetcode.com/problems/spiral-matrix/)
 *
 * - dfs, with direction, visited
 * - PRACTICE: P1
 * - MISTAKES: likes to miss updating visited
 *
 * https://www.youtube.com/watch?v=BJnMZNwUk1M&ab_channel=NeetCode
 */
public class SpiralMatrix {

    @Test
    public void test() {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = spiralOrder(matrix);
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), result);
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     */
    int[][] matrix;
    List<Integer> result = new ArrayList<>();
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        visited = new boolean[matrix.length][matrix[0].length];
        dfs(0, 0, true);
        return result;
    }

    private void dfs(int i, int j, boolean rightDown) {
        //base case - if visited or out of boundary
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        result.add(matrix[i][j]);
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
