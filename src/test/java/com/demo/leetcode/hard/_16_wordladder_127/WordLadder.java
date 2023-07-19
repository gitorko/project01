package com.demo.leetcode.hard._16_wordladder_127;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [127. Word Ladder - HARD](https://leetcode.com/problems/word-ladder/)
 *
 * - bfs
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=h9iTnkgv05E&ab_channel=NeetCode
 */
public class WordLadder {

    @Test
    public void test1() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        Assertions.assertEquals(5, ladderLength(beginWord, endWord, wordList));
        Assertions.assertEquals(5, ladderLength2(beginWord, endWord, wordList));
    }

    @Test
    public void test2() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "tog", "cog");
        Assertions.assertEquals(0, ladderLength(beginWord, endWord, wordList));
        Assertions.assertEquals(0, ladderLength2(beginWord, endWord, wordList));
    }

    /**
     * No need of adjacency list
     * Time: O(m^2 * n), m is char in word, n is size of word list
     * Space: O(m*n)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return result;
                }
                StringBuilder sb = new StringBuilder(word);
                for (int i = 0; i < sb.length(); i++) {
                    char replacedChar = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String tempWord = sb.toString();
                        if (wordSet.contains(tempWord)) {
                            queue.offer(tempWord);
                            wordSet.remove(tempWord);
                        }
                    }
                    sb.setCharAt(i, replacedChar);
                }
                size--;
            }
            result++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Map<String, Set<String>> adjacencyMap = new HashMap<>();
        //add begin word to set
        wordSet.add(beginWord);
        for (String word : wordSet) {
            adjacencyMap.putIfAbsent(word, new HashSet<>());
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (wordSet.contains(newWord) && !newWord.equals(word)) {
                        adjacencyMap.get(word).add(newWord);
                    }
                }
            }
        }
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return result;
                }
                if (!visited.contains(word)) {
                    visited.add(word);
                    //find all neighbours of word
                    for (String neighbour : adjacencyMap.get(word)) {
                        queue.offer(neighbour);
                    }
                }
                size--;
            }
            result++;
        }
        return 0;
    }
}
