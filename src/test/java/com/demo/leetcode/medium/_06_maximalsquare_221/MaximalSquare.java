package com.demo.leetcode.medium._06_maximalsquare_221;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [221. Maximal Square - MEDIUM](https://leetcode.com/problems/maximal-square/)
 *
 * - right+down+diagonal dfs, fill -1
 * - dfs, cache holds square length not area
 * - 1 + Math.min(right, down, diagonal)
 *
 * PRACTICE
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
    }

    /**
     * Time: O(m*n)
     * Space: O(m*n)
     */
    int row;
    int col;
    int dp[][];
    char[][] matrix;
    int maxLen;

    public int maximalSquare(char[][] input) {
        matrix = input;
        row = matrix.length;
        col = matrix[0].length;
        dp = new int[row][col];
        maxLen = 0;
        for (int i = 0; i < row; i++)
            Arrays.fill(dp[i], -1);
        dfs(0, 0);
        return maxLen * maxLen;
    }

    public int dfs(int i, int j) {
        //beyond boundary return 0
        if (i >= row || j >= col) {
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
