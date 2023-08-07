package com.demo.leetcode.medium._16_shortestpathaltcolor_1129;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1129. Shortest Path with Alternating Colors - MEDIUM](https://leetcode.com/problems/shortest-path-with-alternating-colors/)
 *
 * https://www.youtube.com/watch?v=69rcy6lb-HQ&ab_channel=NeetCodeIO
 */
public class ShortestPathAlternateColor {

    @Test
    public void test1() {
        int n = 3;
        int[][] redEdges = {{0, 1}, {1, 2}};
        int[][] blueEdges = {};
        int[] expected = {0, 1, -1};
        Assertions.assertArrayEquals(expected, shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void test2() {
        int n = 4;
        int[][] redEdges = {{0, 2}, {1, 2}};
        int[][] blueEdges = {{0, 1}, {1, 3}, {2, 3}};
        int[] expected = {0, 1, 1, 2};
        Assertions.assertArrayEquals(expected, shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void test3() {
        int n = 5;
        int[][] redEdges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blueEdges = {{1, 2}, {2, 3}, {3, 1}};
        int[] expected = {0, 1, 2, 3, 7};
        Assertions.assertArrayEquals(expected, shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    Map<Integer, Set<Integer>> redAdjMap;
    Map<Integer, Set<Integer>> blueAdjMap;
    int[] result;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        redAdjMap = new HashMap<>();
        blueAdjMap = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            redAdjMap.putIfAbsent(redEdges[i][0], new HashSet<>());
            redAdjMap.get(redEdges[i][0]).add(redEdges[i][1]);
        }
        for (int i = 0; i < blueEdges.length; i++) {
            blueAdjMap.putIfAbsent(blueEdges[i][0], new HashSet<>());
            blueAdjMap.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }
        result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        bfs("BLUE");
        bfs("RED");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }

    private void bfs(String color) {
        //[node, length, previous_color]
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, color));
        Set<String> visited = new HashSet<>();
        visited.add(0 + "_" + color);
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int node = curr.node;
            int length = curr.length;
            String prevColor = curr.prevColor;
            if (prevColor.equals("BLUE")) {
                for (Integer neighbour : redAdjMap.getOrDefault(node, Collections.emptySet())) {
                    if (!visited.contains(neighbour + "_RED")) {
                        visited.add(neighbour + "_RED");
                        result[neighbour] = Math.min(result[neighbour], 1 + length);
                        queue.add(new Pair(neighbour, 1 + length, "RED"));
                    }
                }
            }
            if (prevColor.equals("RED")) {
                for (Integer neighbour : blueAdjMap.getOrDefault(node, Collections.emptySet())) {
                    if (!visited.contains(neighbour + "_BLUE")) {
                        visited.add(neighbour + "_BLUE");
                        result[neighbour] = Math.min(result[neighbour], 1 + length);
                        queue.add(new Pair(neighbour, 1 + length, "BLUE"));
                    }
                }
            }
        }
    }

    class Pair {
        Integer node;
        Integer length;
        String prevColor;

        public Pair(Integer node, Integer length, String prevColor) {
            this.node = node;
            this.length = length;
            this.prevColor = prevColor;
        }
    }
}
