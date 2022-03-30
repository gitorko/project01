package com.demo.leetcode.medium._06_surroundedregion_130;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [130. Surrounded Regions - MEDIUM](https://leetcode.com/problems/surrounded-regions/)
 *
 * - boundary scan
 * - dfs on each O on boundary change to *
 * - last flip all O to X and * to O
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
    int rowLength;
    int colLength;

    public void solve(char[][] input) {
        this.board = input;
        rowLength = board.length;
        colLength = board[0].length;

        if (rowLength < 2 || colLength < 2)
            return;

        //Any 'O' connected to a boundary can't be turned to 'X'
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < rowLength; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(i, 0);
            if (board[i][colLength - 1] == 'O')
                boundaryDFS(i, colLength - 1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < colLength; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(0, j);
            if (board[rowLength - 1][j] == 'O')
                boundaryDFS(rowLength - 1, j);
        }
        //post-processing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(int i, int j) {
        if (i < 0 || j < 0 || i == rowLength || j == colLength || board[i][j] != 'O')
            return;
        board[i][j] = '*';
        boundaryDFS(i - 1, j);
        boundaryDFS(i + 1, j);
        boundaryDFS(i, j - 1);
        boundaryDFS(i, j + 1);
    }
}
