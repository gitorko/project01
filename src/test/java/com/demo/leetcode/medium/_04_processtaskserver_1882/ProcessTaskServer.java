package com.demo.leetcode.medium._04_processtaskserver_1882;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1882. Process Tasks Using Servers - MEDIUM](https://leetcode.com/problems/process-tasks-using-servers/)
 *
 * - two heap
 * - SIMILAR_TO: [1834. Single-Threaded CPU - MEDIUM](https://leetcode.com/problems/single-threaded-cpu/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=XKA22PecuMQ&ab_channel=NeetCode
 */
public class ProcessTaskServer {

    @Test
    public void test() {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] actual = assignTasks(servers, tasks);
        int[] expected = {2, 2, 0, 2, 1, 2};
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Time: O(m * log(n)) (n - size of server array, m-size of task)
     * Space: O(n)
     */
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] result = new int[tasks.length];
        // [end time, index]
        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (servers[a[1]] == servers[b[1]] ? a[1] - b[1] : servers[a[1]] - servers[b[1]]) : a[0] - b[0]);
        // [weight, index]
        PriorityQueue<int[]> unused = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < servers.length; i++) {
            unused.add(new int[]{servers[i], i});
        }
        for (int i = 0; i < tasks.length; i++) {
            //check if any server in used are free to add back to unused.
            while (!used.isEmpty() && used.peek()[0] <= i) {
                int index = used.poll()[1];
                unused.add(new int[]{servers[index], index});
            }
            // check is any server is available
            if (unused.size() > 0) {
                int[] obj = unused.poll();
                int endTime = i + tasks[i];
                int index = obj[1];
                used.add(new int[]{endTime, index});
                result[i] = index;
            } else {
                // if no server available
                int[] obj = used.poll();
                int endTime = obj[0] + tasks[i];
                int index = obj[1];
                used.add(new int[]{endTime, index});
                result[i] = index;
            }
        }
        return result;
    }
}
