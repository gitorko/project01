package com.demo.leetcode.medium._04_mincostticket_983;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [983. Minimum Cost For Tickets - MEDIUM](https://leetcode.com/problems/minimum-cost-for-tickets/)
 *
 * - queue
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=4pY1bsBpIY4&ab_channel=NeetCode
 */
public class MinCostTicket {

    @Test
    public void test() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Assertions.assertEquals(11, mincostTickets(days, costs));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Use two queues to keep the indices of the days that are no earlier than the ith day by 7 days and 30 days,
     */
    public int mincostTickets(int[] days, int[] costs) {
        int result = 0;
        //[day, cost]
        Queue<int[]> last7 = new LinkedList<>();
        Queue<int[]> last30 = new LinkedList<>();

        for (int day : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= day)
                last7.poll();
            while (!last30.isEmpty() && last30.peek()[0] + 30 <= day)
                last30.poll();
            last7.offer(new int[]{day, result + costs[1]});
            last30.offer(new int[]{day, result + costs[2]});
            result = Math.min(result + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }
        return result;
    }
}
