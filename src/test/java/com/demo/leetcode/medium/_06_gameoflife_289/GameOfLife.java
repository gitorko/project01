package com.demo.leetcode.medium._06_gameoflife_289;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [289. Game of Life - MEDIUM](https://leetcode.com/problems/game-of-life/)
 *
 * - binary table
 *
 * https://www.youtube.com/watch?v=fei4bJQdBUQ&ab_channel=NeetCode
 */
public class GameOfLife {

    @Test
    public void test() {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        int[][] expected = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
        Assertions.assertArrayEquals(expected, board);
    }

    /**
     * Original | new | state
     *    0     |  0  |  0
     *    1     |  0  |  1
     *    0     |  1  |  2
     *    1     |  1  |  3
     *
     * Time: O(mn)
     * Space: O(1)
     */
    int[][] board;
    int rowLen;
    int colLen;

    public void gameOfLife(int[][] input) {
        board = input;
        rowLen = board.length;
        colLen = board[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int neighbourCount = countNeighbours(i, j);
                if (board[i][j] == 1) {
                    if (neighbourCount == 2 || neighbourCount == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (neighbourCount == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countNeighbours(int r, int c) {
        int neighbourCount = 0;
        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                if ((i == r && j == c) || i < 0 || j < 0 || i == rowLen || j == colLen)
                    continue;
                if (board[i][j] == 1 || board[i][j] == 3) {
                    neighbourCount++;
                }
            }
        }
        return neighbourCount;
    }
}
