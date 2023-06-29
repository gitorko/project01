package com.demo.leetcode.medium._16_snakeladder_909;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [909. Snakes and Ladders - MEDIUM](https://leetcode.com/problems/snakes-and-ladders/)
 *
 * - bfs
 *
 * https://www.youtube.com/watch?v=6lH4nO3JfLk&ab_channel=NeetCode
 */
public class SnakeLadder {

    @Test
    public void test() {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        Assertions.assertEquals(4, snakesAndLadders(board));
    }

    @Test
    public void test2() {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
        Assertions.assertEquals(6, snakesAndLadders(board));
    }

    /**
     * Time: o(n^2)
     * Space: O(n)
     */
    int length;

    public int snakesAndLadders(int[][] board) {
        length = board.length;
        // [position, moves]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int square = poll[0];
            int move = poll[1];
            for (int i = 1; i < 7; i++) {
                int nextSquare = square + i;
                int[] item = intToPos(nextSquare);
                if (board[item[0]][item[1]] != -1) {
                    nextSquare = board[item[0]][item[1]];
                }
                if (nextSquare == length * length) {
                    return move + 1;
                }
                if (!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.add(new int[]{nextSquare, move + 1});
                }
            }
        }
        return -1;
    }

    private int[] intToPos(int square) {
        int row = (square - 1) / length;
        int col = (square - 1) % length;
        if (row % 2 != 0) {
            col = length - 1 - col;
        }
        row = length - 1 - row;
        return new int[]{row, col};
    }
}
