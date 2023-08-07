package com.demo.leetcode.medium._16_eventualsafestate_802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [802. Find Eventual Safe States - MEDIUM](https://leetcode.com/problems/find-eventual-safe-states/)
 *
 * - map, dfs
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Re_v0j0CRsg&ab_channel=NeetCode
 */
public class EventualSafeState {

    @Test
    public void test() {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> expected = Arrays.asList(2, 4, 5, 6);
        Assertions.assertEquals(expected, eventualSafeNodes(graph));
    }

    /**
     * Time: O(e+v)
     * Space: O(e+v)
     */
    Map<Integer, Boolean> visited;
    Map<Integer, Set<Integer>> adjacencyMap;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        adjacencyMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            adjacencyMap.putIfAbsent(i, new HashSet<>());
            for (int j = 0; j < graph[i].length; j++) {
                adjacencyMap.get(i).add(graph[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int curNode) {
        if (visited.containsKey(curNode)) {
            return visited.get(curNode);
        }
        visited.put(curNode, false);
        for (int neighbour : adjacencyMap.get(curNode)) {
            if (dfs(neighbour) == false) {
                return false;
            }
        }
        visited.put(curNode, true);
        return true;
    }

}
