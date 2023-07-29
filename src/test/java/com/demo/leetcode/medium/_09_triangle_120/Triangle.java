package com.demo.leetcode.medium._09_triangle_120;

import java.util.List;

import com.demo.common.AlgoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [120. Triangle - MEDIUM](https://leetcode.com/problems/triangle/)
 *
 * - min of bottom
 * - SIMILAR_TO: [118. Pascal's Triangle - EASY](https://leetcode.com/problems/pascals-triangle/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=OM1MTokvxs4&ab_channel=NeetCode
 */
public class Triangle {

    @Test
    public void test() {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangleInput = AlgoUtil.twoDArrayToList(triangle);
        Assertions.assertEquals(11, minimumTotal(triangleInput));
    }

    /**
     * Bottom up
     * Time: O(n^2)
     * Space: O(1)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //start form last but one row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                List<Integer> curRow = triangle.get(i);
                List<Integer> botRow = triangle.get(i + 1);
                curRow.set(j, curRow.get(j) + Math.min(botRow.get(j), botRow.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * Top Down recursion
     * Time: O(n^2)
     * Space: O(n)
     */
    List<List<Integer>> triangle;
    Integer[][] dp;

    public int minimumTotalTopDown(List<List<Integer>> input) {
        triangle = input;
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        dp = new Integer[row][col];
        return minimumPath(0, 0);
    }

    private int minimumPath(int index, int row) {
        if (row >= triangle.size() || index >= triangle.get(index).size()) {
            return 0;
        }
        if (dp[row][index] == null) {
            int current = triangle.get(row).get(index);
            int sum1 = current + minimumPath(index + 1, row + 1);
            int sum2 = current + minimumPath(index, row + 1);
            dp[row][index] = Math.min(sum1, sum2);
        }
        return dp[row][index];
    }
}
