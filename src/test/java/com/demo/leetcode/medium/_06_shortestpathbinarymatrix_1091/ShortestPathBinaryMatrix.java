package com.demo.leetcode.medium._06_shortestpathbinarymatrix_1091;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1091. Shortest Path in Binary Matrix - MEDIUM](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
 *
 * - SIMILAR_TO: [221. Maximal Square - MEDIUM](https://leetcode.com/problems/maximal-square/)
 *
 * https://www.youtube.com/watch?v=YnxUdAO7TAo&ab_channel=NeetCodeIO
 */
public class ShortestPathBinaryMatrix {

    @Test
    public void test() {
        int[][] grid = {{0, 1}, {1, 0}};
        Assertions.assertEquals(2, shortestPathBinaryMatrix(grid));
    }

    int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (grid[0][0] == 1 || grid[rowLen - 1][colLen - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.remove();
                if (pop[0] == rowLen - 1 && pop[1] == colLen - 1) {
                    return result + 1;
                }
                for (int k = 0; k < 8; k++) {
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];
                    if (nextX >= 0 && nextX < rowLen && nextY >= 0 && nextY < colLen && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
