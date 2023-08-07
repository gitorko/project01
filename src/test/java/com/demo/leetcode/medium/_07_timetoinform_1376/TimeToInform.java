package com.demo.leetcode.medium._07_timetoinform_1376;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1376. Time Needed to Inform All Employees - MEDIUM](https://leetcode.com/problems/time-needed-to-inform-all-employees/)
 *
 * - bfs
 *
 * https://www.youtube.com/watch?v=zdBYi0p4L5Q&ab_channel=NeetCodeIO
 */
public class TimeToInform {

    @Test
    public void test() {
        int n = 6, headId = 2, manager[] = {2, 2, -1, 2, 2, 2}, informTime[] = {0, 0, 1, 0, 0, 0};
        Assertions.assertEquals(1, numOfMinutes(n, headId, manager, informTime));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            adjacencyMap.putIfAbsent(manager[i], new ArrayList<>());
            adjacencyMap.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        //[id, time]
        queue.add(new int[]{headId, informTime[headId]});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            for (int i : adjacencyMap.getOrDefault(item[0], new ArrayList<>())) {
                queue.add(new int[]{i, item[1] + informTime[i]});
                result = Math.max(result, item[1] + informTime[i]);
            }
        }
        return result;
    }
}
