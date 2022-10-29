package com.demo.leetcode.easy._01_matrixdiagonalsum_1572;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1572. Matrix Diagonal Sum - EASY](https://leetcode.com/problems/matrix-diagonal-sum/)
 *
 * https://www.youtube.com/watch?v=WliTu6gIK7o&ab_channel=NeetCodeIO
 */
public class MatrixDiagSum {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Assertions.assertEquals(25, diagonalSum(matrix));
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += mat[i][i];
            if (i != n - i - 1) {
                result += mat[i][n - i - 1];
            }
        }
        return result;
    }
}
