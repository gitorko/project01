package com.demo.leetcode.medium._09_uniquepath_62;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [62. Unique Paths - MEDIUM](https://leetcode.com/problems/unique-paths/)
 *
 * - fill last row,col
 * - approach will be re-used in unique path 2
 * - SIMILAR_TO: [63. Unique Paths II - MEDIUM](https://leetcode.com/problems/unique-paths-ii/)
 *
 * https://www.youtube.com/watch?v=IlEsdxuD4lY&ab_channel=NeetCode
 */
public class UniquePath {

    @Test
    public void test() {
        Assertions.assertEquals(28, uniquePathsRecursion(3, 7));
        Assertions.assertEquals(28, uniquePaths(3, 7));
    }

    /**
     * Iterative with memoization
     */
    public int uniquePaths(int row, int col) {
        //edge case
        if (row <= 1 || col <= 1) return 1;

        int[][] dp = new int[row][col];

        //fill last column
        for (int j = col - 1; j >= 0; j--) {
            dp[row - 1][j] = 1;
        }

        //fill last row
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col - 1] = 1;
        }

        //Last row and column are already filled so skip them
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    /**
     * Recursion with memoization - Topdown
     *
     * Time: O(m*n)
     * Space: O(m*n)
     */
    int[][] memo;

    public int uniquePathsRecursion(int m, int n) {
        memo = new int[m][n];
        return uniquePathsHelper(m - 1, n - 1);
    }

    private int uniquePathsHelper(int row, int col) {
        if (row < 0 || col < 0) {
            //less than row,col out of bounds
            return 0;
        } else if (row == 0 || col == 0) {
            //first position
            return 1;
        } else if (memo[row][col] > 0) {
            //memoization
            return memo[row][col];
        } else {
            memo[row][col] = uniquePathsHelper(row - 1, col) + uniquePathsHelper(row, col - 1);
            return memo[row][col];
        }
    }
}
