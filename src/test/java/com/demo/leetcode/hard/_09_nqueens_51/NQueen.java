package com.demo.leetcode.hard._09_nqueens_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [51. N-Queens - HARD](https://leetcode.com/problems/n-queens/)
 *
 * - backtracking
 * - negative diagonal = (row - col) = constant
 * - positive diagonal = (row + col) = constant
 *
 * https://www.youtube.com/watch?v=Ph95IHmRp5M&ab_channel=NeetCode
 */
public class NQueen {

    @Test
    public void test() {
        List<List<String>> expected = Arrays.asList(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."), Arrays.asList(".Q..", "...Q", "Q...", "..Q."));
        List<List<String>> actual = solveNQueens(4);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Time: O(n⋅n!)
     * Space: ∣ans∣
     */
    char[][] board;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        result = new ArrayList<>();
        dfs(0);
        return result;
    }

    private void dfs(int colIndex) {
        if (colIndex == board.length) {
            result.add(construct());
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

    private List<String> construct() {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
