package com.demo.leetcode.medium._01_checkmove_1958;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1958. Check if Move is Legal - MEDIUM](https://leetcode.com/problems/check-if-move-is-legal/)
 *
 * https://www.youtube.com/watch?v=KxK33AcQZpQ&ab_channel=NeetCode
 */
public class CheckMove {

    @Test
    public void test() {
        char[][] board = {{'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'}, {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'W', '.', '.', '.', '.'}};
        int rMove = 4;
        int cMove = 3;
        char color = 'B';
        Assertions.assertTrue(checkMove(board, rMove, cMove, color));
    }

    private final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public boolean checkMove(char[][] board, int r, int c, char color) {
        for (int k = 0; k < 8; k++) {
            for (int i = r + d[k][0], j = c + d[k][1], size = 2; 0 <= i && i < 8 && 0 <= j && j < 8; i += d[k][0], j += d[k][1], ++size) {
                if (board[i][j] == '.' || size < 3 && board[i][j] == color) {
                    break;
                }
                if (board[i][j] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}
