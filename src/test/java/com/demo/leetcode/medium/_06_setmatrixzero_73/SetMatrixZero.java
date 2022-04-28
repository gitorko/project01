package com.demo.leetcode.medium._06_setmatrixzero_73;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [73. Set Matrix Zeroes - MEDIUM](https://leetcode.com/problems/set-matrix-zeroes/)
 *
 * - 2 array extra
 * - one extra cell for overlap
 *
 * https://www.youtube.com/watch?v=T41rL0L3Pnw&ab_channel=NeetCode
 */
public class SetMatrixZero {

    @Test
    public void test() {
        int matrix[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int expected[][] = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        Assertions.assertArrayEquals(expected, matrix);

    }

    @Test
    public void test2() {
        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int expected[][] = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void test3() {
        int matrix[][] = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int expected[][] = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void test4() {
        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int expected[][] = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));
        Assertions.assertArrayEquals(expected, matrix);
    }

    /**
     * Time: O(m*n)
     * Space: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean rowZero = false;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    //rowLen
                    matrix[0][j] = 0;
                    //colLen
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }

                }
            }
        }
        //set 0 for all rows and cols other than first rowLen,first colLen
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //handle first column
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }

        //handle first row
        if (rowZero) {
            for (int j = 0; j < colLen; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * Need more space:
     * Time: O(m*n)
     * Space: O(m+n)
     */
    public void setZeroes2(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int rowZero[] = new int[rowLength];
        int colZero[] = new int[colLength];
        Arrays.fill(rowZero, 1);
        Arrays.fill(colZero, 1);

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = 0;
                    colZero[j] = 0;
                }
            }
        }
        for (int i = 0; i < rowZero.length; i++) {
            if (rowZero[i] == 0) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < colZero.length; i++) {
            if (colZero[i] == 0) {
                for (int j = 0; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
