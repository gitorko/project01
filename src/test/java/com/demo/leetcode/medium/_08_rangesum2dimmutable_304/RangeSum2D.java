package com.demo.leetcode.medium._08_rangesum2dimmutable_304;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [304. Range Sum Query 2D - Immutable - MEDIUM](https://leetcode.com/problems/range-sum-query-2d-immutable/)
 *
 * - pre-sum dp
 * - cache matrix with extra row, col
 * - SIMILAR_TO: [303. Range Sum Query - Immutable - EASY](https://leetcode.com/problems/range-sum-query-immutable/)
 *
 * PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=7mL8KJ4Pi70&ab_channel=jayatitiwari
 * https://www.youtube.com/watch?v=KE8MQuwE2yA&ab_channel=NeetCode
 */
public class RangeSum2D {

    @Test
    public void test1() {
        int arr[][] = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix matrix = new NumMatrix(arr);
        Assertions.assertEquals(8, matrix.sumRegion(2, 1, 4, 3));
        Assertions.assertEquals(11, matrix.sumRegion(1, 1, 2, 2));
        Assertions.assertEquals(12, matrix.sumRegion(1, 2, 2, 4));
    }

    @Test
    public void test2() {
        int arr[][] = {{1, 3, 0},
                {6, 5, 4,},
                {8, 4, 2}};
        NumMatrix matrix = new NumMatrix(arr);
        Assertions.assertEquals(15, matrix.sumRegion(1, 1, 2, 2));
    }

    /**
     * Time: O(m*n)
     * Space: O(m*n)
     *
     * SumRegion - Time: O(1)
     */
    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            int rowLen = matrix.length;
            int colLen = matrix[0].length;
            dp = new int[rowLen + 1][colLen + 1];
            // sum[i][j] is sum of all elements inside the rectangle [0,0,i,j]
            for (int i = 1; i <= rowLen; i++) {
                for (int j = 1; j <= colLen; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            r1++;
            c1++;
            r2++;
            c2++; // Since our `sum` starts by 1 so we need to increase r1, c1, r2, c2 by 1
            return dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
        }
    }

}
