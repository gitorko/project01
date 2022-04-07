package com.demo.leetcode.hard._14_aliendictionary_269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [269. Alien Dictionary - HARD](https://leetcode.com/problems/alien-dictionary/)
 *
 * - topological sort
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
        String[] words = {"zy","zx"};
        Assertions.assertEquals("yxz", alienOrder(words));
    }

    Map<Character, Set<Character>> graph;
    String[] words;
    int[] inDegree;

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        this.words = words;
        graph = new HashMap<>();
        inDegree = new int[26];
        buildGraph();
        return topologicalSort();
    }

    private void buildGraph() {
        // create node for each character in each word
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int minLength = Math.min(first.length(), second.length());
            //edge case of invalid input
            if (first.length() > second.length() && first.substring(0, minLength).equals(second.substring(0, minLength))) {
                graph.clear();
                return;
            }
            for (int j = 0; j < minLength; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree[c2 - 'a']++;
                    }
                    break; // later characters' order are meaningless
                }
            }
        }
    }

    private String topologicalSort() {
        //priority queue to preserve lexo graphic order
        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
