package com.demo.leetcode.medium._07_detonatebombs_2101;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2101. Detonate the Maximum Bombs - MEDIUM](https://leetcode.com/problems/detonate-the-maximum-bombs/description/)
 *
 * - bfs
 *
 * https://www.youtube.com/watch?v=8NPbAvVXKR4&ab_channel=NeetCodeIO
 */
public class DetonateBombs {

    @Test
    public void test1() {
        int bombs[][] = {{2, 1, 3}, {6, 1, 4}};
        Assertions.assertEquals(2, maximumDetonation(bombs));
    }

    @Test
    public void test2() {
        int bombs[][] = {{7, 26, 7}, {7, 18, 4}, {3, 10, 7}, {17, 50, 1}, {3, 25, 10}, {85, 23, 8}, {80, 50, 1}, {58, 74, 1}, {38, 39, 7}, {50, 51, 8}, {31, 99, 3}, {53, 6, 5}, {59, 27, 10}, {87, 78, 9}, {68, 58, 3}};
        Assertions.assertEquals(3, maximumDetonation(bombs));
    }

    /**
     * Time: O(n^3)
     * Space: O(n^2)
     */
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = bombs[i][0];
                int xj = bombs[j][0];
                int yi = bombs[i][1];
                int yj = bombs[j][1];
                int ri = bombs[i][2];
                int rj = bombs[j][2];

                long distance = (long) (xi - xj) * (xi - xj) + (long) (yi - yj) * (yi - yj);
                if (distance <= (long) ri * ri) {
                    //i can detonate j
                    adjacencyMap.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
                if (distance <= (long) rj * rj) {
                    //j can detonate i
                    adjacencyMap.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, bfs(i, adjacencyMap));
        }
        return result;
    }

    private int bfs(int i, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(i);
        visited.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return visited.size();
    }
}
