package com.demo.leetcode.medium._03_taskscheduler_621;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [621. Task Scheduler - MEDIUM](https://leetcode.com/problems/task-scheduler/)
 *
 * - max heap + map, currTime
 * - SIMILAR_TO: [767. Reorganize String - MEDIUM](https://leetcode.com/problems/reorganize-string/)
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

    /**
     * Time: O(∣tasks∣)
     * Space: O(26)
     *
     * Greedy - It's obvious that we should always process the task which has largest amount left.
     * Put tasks (only their counts are enough, we don't care they are 'A' or 'B') in a PriorityQueue in descending order.
     * Start to process tasks from front of the queue. If amount left > 0, put it into a coolDown HashMap
     * If there's task which cool-down expired, put it into the queue and wait to be processed.
     * Repeat step 3, 4 till there is no task left.
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        Map<Character, Integer> taskToCount = new HashMap<>();
        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }

        //max heap
        Queue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pq.addAll(taskToCount.values());

        //key is time, value is remaining
        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while (!pq.isEmpty() || !coolDown.isEmpty()) {
            currTime++;
            if (!pq.isEmpty()) {
                int remaining = pq.poll() - 1;
                if (remaining != 0) coolDown.put(currTime + n, remaining);
            }
            if (coolDown.containsKey(currTime)) {
                pq.offer(coolDown.remove(currTime));
            }
        }
        return currTime;
    }
}
