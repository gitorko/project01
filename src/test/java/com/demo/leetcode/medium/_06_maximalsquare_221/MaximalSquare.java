package com.demo.leetcode.medium._06_maximalsquare_221;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [221. Maximal Square - MEDIUM](https://leetcode.com/problems/maximal-square/)
 *
 * - start from reverse
 * - 1 + Math.min(right, down, diagonal)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=6X7Ha2PrDmM&ab_channel=NeetCode
 */
public class MaximalSquare {

    @Test
    public void test() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        Assertions.assertEquals(4, maximalSquare(matrix));
        Assertions.assertEquals(4, maximalSquare2(matrix));
    }

    /**
     * Time: O(m*n)
     * Space: O(m*n), can be reduced to O(1) if matrix is used dp, hence we start from reverse.
     */
    public int maximalSquare(char[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] dp = new int[rowLen][colLen];
        int maxLength = 0;
        for (int i = rowLen - 1; i >= 0; i--) {
            for (int j = colLen - 1; j >= 0; j--) {
                //last row or last column case or if cell is zero case
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (i == rowLen - 1 || j == colLen - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength * maxLength;
    }

    /**
     * DFS approach
     * Time: O(m*n)
     * Space: O(m*n)
     */
    int rowLength;
    int colLength;
    int dp[][];
    char[][] matrix;
    int maxLen;

    public int maximalSquare2(char[][] matrix) {
        this.matrix = matrix;
        rowLength = matrix.length;
        colLength = matrix[0].length;
        dp = new int[rowLength][colLength];
        maxLen = 0;
        for (int i = 0; i < rowLength; i++) {
            Arrays.fill(dp[i], -1);
        }
        dfs(0, 0);
        return maxLen * maxLen;
    }

    public int dfs(int i, int j) {
        //beyond boundary return 0
        if (i >= rowLength || j >= colLength) {
            return 0;
        }
        //not in cache
        if (dp[i][j] == -1) {
            int down = dfs(i + 1, j);
            int right = dfs(i, j + 1);
            int diag = dfs(i + 1, j + 1);
            if (matrix[i][j] == '1') {
                //remember to add +1
                dp[i][j] = 1 + Math.min(diag, Math.min(right, down));
            } else {
                dp[i][j] = 0;
            }
        }
        if (dp[i][j] > maxLen) {
            maxLen = dp[i][j];
        }
        return dp[i][j];
    }

}
