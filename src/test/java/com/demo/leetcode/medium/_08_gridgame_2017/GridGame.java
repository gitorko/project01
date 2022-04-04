package com.demo.leetcode.medium._08_gridgame_2017;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2017. Grid Game - MEDIUM](https://leetcode.com/problems/grid-game/)
 *
 * - pre-sum
 *
 * https://www.youtube.com/watch?v=N4wDSOw65hI&ab_channel=NeetCode
 */
public class GridGame {

    @Test
    public void test() {
        int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        Assertions.assertEquals(4, gridGame(grid));
    }

    /**
     * Since the robots cannot go up, we need to find the best point i for the first robot to go down.
     * For the second robot, we only have two choices - go down right away, or stay up till the end.
     * For a point i, the second robot can either collect bottom = sum(grid[1][0] .. grid[1][i - 1]) if it goes down, or top = sum(grid[0][i + 1] ... grid[0][n - 1]) otherwise.
     * We can compute those values using prefix/suffix sum in O(1), and then find the minimum of max(top, bottom).
     * Note that the prefix/suffix sum can overflow int, so we need to use a long.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long result = Long.MAX_VALUE;
        long topRow = Arrays.stream(grid[0]).asLongStream().sum();
        long bottomRow = 0;
        for (int i = 0; i < n; i++) {
            topRow -= grid[0][i];
            result = Math.min(result, Math.max(topRow, bottomRow));
            bottomRow += grid[1][i];
        }
        return result;
    }
}
