package com.demo.leetcode.medium._03_taskscheduler_621;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [621. Task Scheduler - MEDIUM](https://leetcode.com/problems/task-scheduler/)
 *
 * - max heap + queue, time
 * - SIMILAR_TO: [767. Reorganize String - MEDIUM](https://leetcode.com/problems/reorganize-string/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=s8p8ukTyA2I&ab_channel=NeetCode
 */
public class TaskScheduler {

    @Test
    public void test1() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        Assertions.assertEquals(8, leastInterval(tasks, n));
    }

    @Test
    public void test2() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C'};
        int n = 1;
        Assertions.assertEquals(7, leastInterval(tasks, n));
    }

    @Test
    public void test3() {
        char[] tasks = {'A', 'A', 'A'};
        int n = 2;
        Assertions.assertEquals(7, leastInterval(tasks, n));
    }

    /**
     * Time: O(n * m) m is the idle time
     * Space: O(26)
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : tasks) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        //max heap holds count of each task
        Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pq.addAll(countMap.values());
        //[count, time available]
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int remaining = pq.poll() - 1;
                if (remaining != 0) {
                    queue.offer(new int[]{remaining, time + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
