package com.demo.leetcode.hard._09_nqueens2_52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [52. N-Queens II - HARD](https://leetcode.com/problems/n-queens-ii/)
 *
 * - backtracking
 * - negative diagonal = (row - col) = constant
 * - positive diagonal = (row + col) = constant
 * - SIMILAR_TO: [51. N-Queens - HARD](https://leetcode.com/problems/n-queens/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Ph95IHmRp5M&ab_channel=NeetCode
 */
public class NQueen2 {

    @Test
    public void test() {
        Assertions.assertEquals(2, totalNQueens(4));
    }

    /**
     * Time: O(n⋅n!)
     * Space: ∣ans∣
     */
    char[][] board;
    int result;

    public int totalNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        result = 0;
        dfs(0);
        return result;
    }

    private void dfs(int colIndex) {
        if (colIndex == board.length) {
            result++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                //check diagonals, check same row
                if (board[i][j] == 'Q' && (x - y == i - j || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

}
