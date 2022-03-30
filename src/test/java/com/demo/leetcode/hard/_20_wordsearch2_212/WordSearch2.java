package com.demo.leetcode.hard._20_wordsearch2_212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [212. Word Search II - HARD](https://leetcode.com/problems/word-search-ii/)
 *
 * - trie, backtracking, dfs
 * - SIMILAR_TO: [79. Word Search - MEDIUM](https://leetcode.com/problems/word-search/)
 *
 * https://www.youtube.com/watch?v=asbcE9mZz_U&ab_channel=NeetCode
 */
public class WordSearch2 {

    @Test
    public void test() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> expected = Arrays.asList("oath", "eat");
        Assertions.assertEquals(expected, findWords(board, words));
    }

    /**
     * Time: O(mn * max(∣words[i]∣))
     * Space: O(Σ∣strings[i]∣)
     */
    TrieNode root;
    List<String> result;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        result = new ArrayList<>();
        visited = new boolean[board.length][board[0].length];
        for (String word : words)
            insert(word);

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                dfs(board, i, j, root);

        return result;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.word = word;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j])
            return;

        char c = board[i][j];
        TrieNode child = node.children[c - 'a'];
        if (child == null)
            return;
        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }

        visited[i][j] = true;
        dfs(board, i + 1, j, child);
        dfs(board, i - 1, j, child);
        dfs(board, i, j + 1, child);
        dfs(board, i, j - 1, child);
        visited[i][j] = false;
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word;
    }
}
