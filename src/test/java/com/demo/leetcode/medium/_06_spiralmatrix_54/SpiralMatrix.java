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
    int rowLen;
    int colLen;
    List<Integer> result = new ArrayList<>();
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] input) {
        matrix = input;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        if (rowLen == 0) return result;

        visited = new boolean[rowLen][colLen];
        dfs(0, 0, false);
        return result;
    }

    private void dfs(int i, int j, boolean up) {

        //if visited or out of boundary
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || visited[i][j])
            return;

        visited[i][j] = true;
        result.add(matrix[i][j]);
        if (up) { // if we are going up
            dfs(i - 1, j, true); // keep going
            dfs(i, j + 1, false); //then turn right
        } else {
            dfs(i, j + 1, false); //go right
            dfs(i + 1, j, false); //go down
            dfs(i, j - 1, false); //go left
            dfs(i - 1, j, true); //go up
        }
    }
}
