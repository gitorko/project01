package com.demo.leetcode.easy._16_shift2dgrid_1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1260. Shift 2D Grid - EASY](https://leetcode.com/problems/shift-2d-grid/)
 *
 * - mod k
 * - (i * n column + j + k) mod (m * n)
 *
 * https://www.youtube.com/watch?v=nJYFh4Dl-as&ab_channel=NeetCode
 */
public class Shift2DGrid {

    @Test
    public void test() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(9, 1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8));
        Assertions.assertEquals(expected, shiftGrid(grid, k));
    }

    /**
     * Time: O(n*m)
     * Space: O(n*m)
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] arr = new int[rowLen][colLen];
        //cases when k is bigger than row*col
        k %= rowLen * colLen;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int index = (i * colLen + j + k) % (rowLen * colLen);
                int x = index / colLen;
                int y = index % colLen;
                arr[x][y] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : arr) {
            result.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        }
        return result;
    }
}
