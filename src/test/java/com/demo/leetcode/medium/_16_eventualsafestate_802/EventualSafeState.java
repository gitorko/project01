package com.demo.leetcode.medium._16_eventualsafestate_802;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [802. Find Eventual Safe States - MEDIUM](https://leetcode.com/problems/find-eventual-safe-states/)
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
     * Time: O(∣V∣+∣E∣)
     * Space: O(∣V∣+∣E∣)
     */

    int[][] graph;
    Map<Integer, Boolean> visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        List<Integer> result = new ArrayList<>();
        visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i))
                result.add(i);
        }
        return result;
    }

    private boolean dfs(int u) {
        if (visited.containsKey(u))
            return visited.get(u);

        visited.put(u, false);
        for (int v : graph[u])
            if (!dfs(v))
                return false;
        visited.put(u, true);
        return true;
    }

}
