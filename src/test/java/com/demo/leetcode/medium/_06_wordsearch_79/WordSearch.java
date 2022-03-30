package com.demo.leetcode.medium._06_wordsearch_79;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [79. Word Search - MEDIUM](https://leetcode.com/problems/word-search/)
 *
 * - dfs + visited, backtracking
 * - remember to remove from visited
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=pfiQ_PS1g8E&ab_channel=NeetCode
 */
public class WordSearch {

    @Test
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Assertions.assertTrue(exist(board, word));
    }

    /**
     * Time: O(m * n * 4^len(word)) - 4 branches
     * Space: O(mn)
     */
    char[][] board;
    int rowLen;
    int colLen;
    String word = "";
    boolean[][] visited;

    public boolean exist(char[][] inputBoard, String inputWord) {
        board = inputBoard;
        rowLen = board.length;
        colLen = board[0].length;
        visited = new boolean[rowLen][colLen];
        word = inputWord;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        //found the char
        if (index == word.length()) {
            return true;
        }
        //out of bounds or already visited.
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        //add to visited
        visited[i][j] = true;
        //dfs on all sides
        boolean found = dfs(i - 1, j, index + 1) ||
                dfs(i, j - 1, index + 1) ||
                dfs(i, j + 1, index + 1) ||
                dfs(i + 1, j, index + 1);
        //remove visited, backtracking
        visited[i][j] = false;
        return found;
    }
}
