package com.demo.leetcode.hard._16_swiminrisingwater_778;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [778. Swim in Rising Water - HARD](https://leetcode.com/problems/swim-in-rising-water/)
 *
 * - djikstra algo min heap
 *
 * https://www.youtube.com/watch?v=amvrKlMLuGY&ab_channel=NeetCode
 */
public class SwimInRisingWater {

    @Test
    public void test1() {
        int[][] grid = {{0, 2}, {1, 3}};
        Assertions.assertEquals(3, swimInWater(grid));
    }

    @Test
    public void test2() {
        int[][] grid = {{0, 1, 3}, {2, 4, 2}, {1, 1, 1}};
        Assertions.assertEquals(2, swimInWater(grid));
    }

    /**
     * Time: O(n^2 log (n))
     * Space: O(n)
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int result = grid[0][0];
        int[] dirs = {0, 1, 0, -1, 0};
        // [height, row, col]
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[n][n];

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        seen[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            int height = poll[0];
            int i = poll[1];
            int j = poll[2];
            result = Math.max(result, height);
            //if end is reached break, you will reach the end and not touch max height due to min heap
            if (i == n - 1 && j == n - 1)
                break;
            //check all directions
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x < 0 || y < 0 || x == n || y == n || seen[x][y])
                    continue;
                minHeap.offer(new int[]{grid[x][y], x, y});
                seen[x][y] = true;
            }
        }
        return result;
    }

}
