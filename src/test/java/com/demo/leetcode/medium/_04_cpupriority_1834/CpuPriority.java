package com.demo.leetcode.medium._04_cpupriority_1834;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1834. Single-Threaded CPU - MEDIUM](https://leetcode.com/problems/single-threaded-cpu/)
 *
 * - heap
 * - fast forward time, add index
 *
 * PRACTICE: P1
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
        int length = tasks.length;
        int[][] pool = new int[length][3];
        //add index which is order
        //[startTime, takesTime, indexOrder]
        for (int i = 0; i < length; i++) {
            pool[i][0] = tasks[i][0];
            pool[i][1] = tasks[i][1];
            pool[i][2] = i;
        }
        //sort based on startTime
        Arrays.sort(pool, (a, b) -> a[0] - b[0]);

        //index 0 is start time.
        //index 1 is completion time.
        //index 2 is actual position.
        PriorityQueue<int[]> readyQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int time = 0;
        int index = 0;
        int i = 0;
        int[] result = new int[length];

        while (index < length) {
            //add to queue if time is in future
            while (i < length && time >= pool[i][0])
                readyQueue.offer(pool[i++]);

            if (!readyQueue.isEmpty()) {
                int[] curTask = readyQueue.poll();
                result[index++] = curTask[2];
                time += curTask[1];
            } else {
                //fast forward time
                time = Math.max(time, pool[i][0]);
            }
        }
        return result;
    }
}
