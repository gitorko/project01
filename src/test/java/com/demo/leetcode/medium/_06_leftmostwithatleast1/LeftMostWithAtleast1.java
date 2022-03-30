package com.demo.leetcode.medium._06_leftmostwithatleast1;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1428. Leftmost Column with at Least a One - MEDIUM](https://leetcode.com/problems/leftmost-column-with-at-least-a-one/)
 * https://leetcode.ca/all/1428.html
 *
 * - sorted row
 * - ladder
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=K2E5fMMAf5U&ab_channel=TECHDOSE
 */
public class LeftMostWithAtleast1 {

    @Test
    public void test() {
        int[][] matrix = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 1, 1}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(matrix);
        Assertions.assertEquals(1, leftMostColumnWithOne(binaryMatrix));
    }

    /**
     * Time: O(m+n)
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int rowLen = dimension.get(0);
        int colLen = dimension.get(1);
        int result = -1;
        int row = 0;
        int col = colLen - 1;
        while (row < rowLen && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                result = col;
                col--;
            } else {
                row++;
            }
        }
        return result;
    }

    class BinaryMatrix {
        int[][] matrix;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int get(int x, int y) {
            return matrix[x][y];
        }

        public List<Integer> dimensions() {
            return Arrays.asList(matrix.length, matrix[0].length);
        }
    }
}
