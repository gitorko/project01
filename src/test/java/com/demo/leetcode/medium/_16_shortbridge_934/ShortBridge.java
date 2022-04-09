package com.demo.leetcode.medium._16_shortbridge_934;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [934. Shortest Bridge - MEDIUM](https://leetcode.com/problems/shortest-bridge/)
 *
 * - dfs + bfs
 * - visited
 * - paint first island as 2 using dfs, then add all such nodes to queue. Use bfs to find the next 1 island.
 *
 * https://www.youtube.com/watch?v=gkINMhbbIbU&ab_channel=NeetCode
 */
public class ShortBridge {

    @Test
    public void test() {
        int[][] grid = {{0, 1}, {1, 0}};
        Assertions.assertEquals(1, shortestBridge(grid));
    }

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    int[][] matrix;
    int rowLen;
    int colLen;

    public int shortestBridge(int[][] input) {
        matrix = input;
        rowLen = matrix.length;
        colLen = matrix[0].length;

        //paint one island with int 2
        paint();

        //queue contains coordinates to do bfs
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLen][colLen];

        //initialize queue with all coordinates with number 2
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        //level order bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //found, then return
                if (matrix[x][y] == 1) {
                    return level - 1;
                }
                //add all neighbours at level, remember to check out of bounds and visited case
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x + 1 < rowLen && !visited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y + 1 < colLen && !visited[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
                size--;
            }
            level++; //next level
        }
        return -1;
    }

    //paint one island with int 2
    public void paint() {
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 1) {
                    dfs(i, j);
                    //return after painting first island
                    return;
                }
            }
        }
    }

    //helper function for paint function
    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x > rowLen - 1 || y > colLen - 1 || matrix[x][y] != 1) {
            return;
        }
        matrix[x][y] = 2;
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}
