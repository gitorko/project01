package com.demo.basics.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [208. Implement Trie, Prefix Tree - EASY](https://leetcode.com/problems/implement-trie-prefix-tree/)
 *
 * - current node
 * - SIMILAR_TO: [211. Design Add and Search Words Data Structure - MEDIUM](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=oobqoCJlHA0&ab_channel=NeetCode
 */
public class CustomTrie {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));

    }

    class Trie {
        private TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new TrieNode();
                }
                curr = curr.children[i];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    return false;
                }
                curr = curr.children[i];
            }
            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    return false;
                }
                curr = curr.children[i];
            }
            return true;
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
}
