package com.demo.leetcode.medium._04_cpupriority_1834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1834. Single-Threaded CPU - MEDIUM](https://leetcode.com/problems/single-threaded-cpu/)
 *
 * - min heap, sort
 * - fast forward time, add index
 * - SIMILAR_TO: [1882. Process Tasks Using Servers](https://leetcode.com/problems/process-tasks-using-servers/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=RR1n-d4oYqE&ab_channel=NeetCode
 */
public class CpuPriority {

    @Test
    public void test() {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] actual = getOrder(tasks);
        int[] expected = {0, 2, 3, 1};
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     */
    public int[] getOrder(int[][] tasks) {
        int[][] pool = new int[tasks.length][3];
        //[startTime, takesTime, indexPosition]
        for (int i = 0; i < tasks.length; i++) {
            pool[i][0] = tasks[i][0];
            pool[i][1] = tasks[i][1];
            pool[i][2] = i;
        }
        //sort based on startTime
        Arrays.sort(pool, (a, b) -> a[0] - b[0]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int curTime = 0;
        List<Integer> result = new ArrayList<>();
        int i = 0;
        //Till result doesnt contain all tasks
        while (result.size() < tasks.length) {
            //add to queue if curTime is in future
            while (i < tasks.length && pool[i][0] <= curTime) {
                minHeap.offer(pool[i]);
                i++;
            }
            if (!minHeap.isEmpty()) {
                int[] curTask = minHeap.poll();
                result.add(curTask[2]);
                curTime += curTask[1];
            } else {
                //fast-forward curTime
                curTime = pool[i][0];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
