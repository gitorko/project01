package com.demo.leetcode.medium._08_gridgame_2017;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2017. Grid Game - MEDIUM](https://leetcode.com/problems/grid-game/)
 *
 * - pre-sum
 * - result is max at start
 *
 * https://www.youtube.com/watch?v=N4wDSOw65hI&ab_channel=NeetCode
 */
public class GridGame {

    @Test
    public void test1() {
        int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        Assertions.assertEquals(4, gridGame(grid));
    }

    @Test
    public void test2() {
        int[][] grid = {{1000, 1, 1}, {1, 1, 1}};
        Assertions.assertEquals(1, gridGame(grid));
    }

    @Test
    public void test3() {
        int[][] grid = {{1, 1, 1}, {1000, 1, 1}};
        Assertions.assertEquals(2, gridGame(grid));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * simulation is for second robot hence pick min
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
