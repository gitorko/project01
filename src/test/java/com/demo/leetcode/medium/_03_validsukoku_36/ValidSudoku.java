package com.demo.leetcode.medium._03_validsukoku_36;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [36. Valid Sudoku - MEDIUM](https://leetcode.com/problems/valid-sudoku/)
 *
 * - Set
 */
public class ValidSudoku {

    @Test
    public void test() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Assertions.assertTrue(isValidSudoku(board));
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                char c = board[i][j];
                //set returns true if element didnt already exist
                if (!seen.add(c + "@row" + i) ||
                        !seen.add(c + "@col" + j) ||
                        !seen.add(c + "@box" + i / 3 + j / 3))
                    return false;
            }
        }
        return true;
    }
}
