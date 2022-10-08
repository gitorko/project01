package com.demo.leetcode.medium._06_wallgate_286;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [286. Walls and Gates - MEDIUM](https://leetcode.com/problems/walls-and-gates)
 *
 * - bfs from gate
 * - PRACTICE: P1
 *
 * https://www.lintcode.com/problem/walls-and-gates/description
 * https://www.youtube.com/watch?v=e69C6xhiSQE&ab_channel=NeetCode
 */
public class WallGate {

    @Test
    public void test() {
        int[][] rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        int[][] expected = {{3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}};
        wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     *
     * 0 is gate
     * -1 is wall
     * inf is room
     */
    int rowLen;
    int colLen;
    boolean[][] visited;
    Queue<int[]> queue;
    int[][] rooms;

    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        rowLen = rooms.length;
        colLen = rooms[0].length;
        queue = new LinkedList<>();
        visited = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rooms[i][j] == 0) {
                    //add all gates
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level > 0) {
                int[] p = queue.poll();
                int i = p[0];
                int j = p[1];
                rooms[i][j] = distance;
                addRoom(i + 1, j);
                addRoom(i - 1, j);
                addRoom(i, j + 1);
                addRoom(i, j - 1);
                level--;
            }
            distance++;
        }
    }

    private void addRoom(int i, int j) {
        if (i < 0 || j < 0 || i == rowLen || j == colLen || visited[i][j] || rooms[i][j] == -1) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
    }
}
