package com.demo.leetcode.medium._20_addsearchwords_211;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [211. Design Add and Search Words Data Structure - MEDIUM](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
 *
 * - prefix tree
 * - SIMILAR_TO: [208. Implement Trie, Prefix Tree - EASY](https://leetcode.com/problems/implement-trie-prefix-tree/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=BTf05gs_8iU&ab_channel=NeetCode
 */
public class AddSearchWords {

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad"));
        Assertions.assertTrue(wordDictionary.search("bad"));
        Assertions.assertTrue(wordDictionary.search(".ad"));
        Assertions.assertTrue(wordDictionary.search("b.."));
    }

    class WordDictionary {

        private TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int startIndex, TrieNode node) {
            //end case
            if (startIndex == word.length()) {
                return node.isWord;
            }
            if (word.charAt(startIndex) == '.') {
                // word.charAt(startIndex) == '.' -> search all 26 children
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && dfs(word, startIndex + 1, node.children[i])) {
                        return true;
                    }
                }
            } else {
                TrieNode next = node.children[word.charAt(startIndex) - 'a'];
                return next == null ? false : dfs(word, startIndex + 1, next);
            }
            return false;
        }

        class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord;
        }
    }
}
