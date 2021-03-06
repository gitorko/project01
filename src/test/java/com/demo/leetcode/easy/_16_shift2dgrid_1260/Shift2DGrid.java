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
 * - mod k ,k %= m * n
 * - i * n column + j + k mod (m * n)
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

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int[][] arr = new int[rowLength][colLength];

        k %= rowLength * colLength;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                int index = (i * colLength + j + k) % (rowLength * colLength);
                int x = index / colLength;
                int y = index % colLength;
                arr[x][y] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : arr)
            result.add(Arrays.stream(row).boxed().collect(Collectors.toList()));

        return result;
    }
}
