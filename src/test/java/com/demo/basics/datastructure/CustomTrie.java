package com.demo.basics.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [208. Implement Trie, Prefix Tree - EASY](https://leetcode.com/problems/implement-trie-prefix-tree/)
 *
 * - current node
 * - SIMILAR_TO: https://leetcode.com/problems/design-add-and-search-words-data-structure/
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
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (current.children[i] == null) {
                    current.children[i] = new TrieNode();
                }
                current = current.children[i];
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (current.children[i] == null) return false;
                current = current.children[i];
            }
            return current.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (current.children[i] == null) return false;
                current = current.children[i];
            }
            return true;
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

}
