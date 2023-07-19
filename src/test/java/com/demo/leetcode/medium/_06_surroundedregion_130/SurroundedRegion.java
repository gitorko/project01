package com.demo.leetcode.medium._06_surroundedregion_130;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [130. Surrounded Regions - MEDIUM](https://leetcode.com/problems/surrounded-regions/)
 *
 * - boundary scan
 * - dfs on each O on boundary change to *
 * - last flip all O to X and * to O
 * - PRACTICE: P2
 */
public class SurroundedRegion {

    @Test
    public void test() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] expected = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        Assertions.assertArrayEquals(expected, board);
    }

    char[][] board;
    int rowLen;
    int colLen;

    public void solve(char[][] input) {
        this.board = input;
        rowLen = board.length;
        colLen = board[0].length;
        if (rowLen < 2 || colLen < 2) {
            return;
        }
        //Any 'O' connected to a boundary can't be turned to 'X'
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < rowLen; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][colLen - 1] == 'O') {
                dfs(i, colLen - 1);
            }
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < colLen; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[rowLen - 1][j] == 'O') {
                dfs(rowLen - 1, j);
            }
        }
        //post-processing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i == rowLen || j == colLen || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
