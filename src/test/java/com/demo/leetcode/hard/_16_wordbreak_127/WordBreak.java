package com.demo.leetcode.hard._16_wordbreak_127;

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
 *
 * https://www.youtube.com/watch?v=h9iTnkgv05E&ab_channel=NeetCode
 */
public class WordBreak {

    @Test
    public void test1() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        Assertions.assertEquals(5, ladderLength(beginWord, endWord, wordList));
    }

    @Test
    public void test2() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "tog", "cog");
        Assertions.assertEquals(0, ladderLength(beginWord, endWord, wordList));
    }

    /**
     * Time: O(n * 26 + m), m is word list, n is length of each word
     * Space: O(|m|)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Map<String, Set<String>> adjacencyMap = new HashMap<>();
        //add begin to word list
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);
        for (String word : wordList) {
            adjacencyMap.computeIfAbsent(word, k -> new HashSet<>());
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

        int result = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return result;
                if (!visited.contains(word)) {
                    visited.add(word);
                    //find all neighbours of word
                    for (String neighbour : adjacencyMap.get(word)) {
                        queue.offer(neighbour);
                    }
                }
                size--;
            }
        }
        return 0;
    }

    /**
     * Time: O(n^2)
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        int result = 0;
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(beginWord));

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            while (size > 0) {
                StringBuilder sb = new StringBuilder(queue.poll());
                for (int i = 0; i < sb.length(); i++) {
                    char cache = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String word = sb.toString();
                        if (word.equals(endWord))
                            return result + 1;
                        if (wordSet.contains(word)) {
                            queue.offer(word);
                            wordSet.remove(word);
                        }
                    }
                    sb.setCharAt(i, cache);
                }
                size--;
            }
        }
        return 0;
    }
}
