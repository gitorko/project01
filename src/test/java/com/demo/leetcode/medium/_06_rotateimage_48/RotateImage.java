package com.demo.leetcode.medium._06_rotateimage_48;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [48. Rotate Image - MEDIUM](https://leetcode.com/problems/rotate-image/)
 *
 * - transpose swap(matrix[i][j], matrix[j][i]) + flip the matrix horizontally.
 *
 * https://www.youtube.com/watch?v=fMSJSS7eO1w&ab_channel=NeetCode
 */
public class RotateImage {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        rotate(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
