package com.demo.leetcode.hard._14_aliendictionary_269;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [269. Alien Dictionary - HARD](https://leetcode.com/problems/alien-dictionary/)
 *
 * - https://www.lintcode.com/problem/892/
 * - topological sort (BFS)
 * - SIMILAR_TO: [210. Course Schedule II - MEDIUM](https://leetcode.com/problems/course-schedule-ii/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=6kTZYvNNyps&ab_channel=NeetCode
 */
public class AlienDictionary {

    @Test
    public void test1() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Assertions.assertEquals("wertf", alienOrder(words));
    }

    @Test
    public void test2() {
        String[] words = {"zy", "zx"};
        Assertions.assertEquals("zyx", alienOrder(words));
    }

    @Test
    public void test3() {
        String[] words = {"a", "ba", "bc", "c"};
        Assertions.assertEquals("abc", alienOrder(words));
    }

    /**
     * Time: O(num of chars)
     */
    Map<Character, Set<Character>> adjacencyMap;
    Set<Character> visitedSet;
    Set<Character> cycleSet;
    String[] words;

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        this.words = words;
        adjacencyMap = new HashMap<>();
        visitedSet = new LinkedHashSet<>();
        cycleSet = new HashSet<>();
        // build the graph
        // create node for each character in each word
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacencyMap.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int minLength = Math.min(first.length(), second.length());
            //edge case of invalid input
            if (first.length() > second.length() && first.substring(0, minLength).equals(second.substring(0, minLength))) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    adjacencyMap.get(c1).add(c2);
                    break; // later characters' order are meaningless
                }
            }
        }
        for (Character c : adjacencyMap.keySet()) {
            if (!dfs(c)) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : visitedSet) {
            sb.append(ch);
        }
        return sb.reverse().toString();
    }

    private boolean dfs(Character c) {
        if (cycleSet.contains(c)) {
            return false;
        }
        if (visitedSet.contains(c)) {
            return true;
        }
        cycleSet.add(c);
        Set<Character> neighbours = adjacencyMap.getOrDefault(c, Collections.emptySet());
        for (Character neighbour : neighbours) {
            if (!dfs(neighbour)) {
                return false;
            }
        }
        cycleSet.remove(c);
        visitedSet.add(c);
        return true;
    }
}
