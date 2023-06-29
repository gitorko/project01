package com.demo.leetcode.medium._16_rottenorange_994;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [994. Rotting Oranges - MEDIUM](https://leetcode.com/problems/rotting-oranges/)
 *
 * - bfs, fresh count, time
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=y704fEOx0s0&ab_channel=NeetCode
 */
public class RottenOrange {

    @Test
    public void test() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        Assertions.assertEquals(4, orangesRotting(grid));
    }

    /**
     * Time: O(m*n)
     * Space: O(m*n)
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            while (size > 0) {
                int[] pair = queue.poll();
                int x = pair[0];
                int y = pair[1];

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.offer(new int[]{x - 1, y});
                    fresh--;
                }
                if (x + 1 < rowLen && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.offer(new int[]{x + 1, y});
                    fresh--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.offer(new int[]{x, y - 1});
                    fresh--;
                }
                if (y + 1 < colLen && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.offer(new int[]{x, y + 1});
                    fresh--;
                }
                size--;
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
