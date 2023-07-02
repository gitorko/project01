package com.demo.leetcode.medium._04_mincostticket_983;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [983. Minimum Cost For Tickets - MEDIUM](https://leetcode.com/problems/minimum-cost-for-tickets/)
 *
 * - two queue, two math.min
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=4pY1bsBpIY4&ab_channel=NeetCode
 */
public class MinCostTicket {

    @Test
    public void test() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Assertions.assertEquals(11, mincostTickets(days, costs));
        Assertions.assertEquals(11, mincostTickets2(days, costs));
        Assertions.assertEquals(11, mincostTickets3(days, costs));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        boolean[] travelDay = new boolean[maxDay + 1];
        for (int day : days) {
            travelDay[day] = true;
        }
        int[] dp = new int[maxDay + 1];
        dp[0] = 0;
        for (int i = 1; i <= maxDay; i++) {
            if (!travelDay[i]) {
                //don't have to buy a ticket if it is not a travel day
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            //max will prevent out of bounds when index goes negative
        }
        return dp[maxDay];
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Use two queues to keep the indices of the days that are no earlier than the ith day by 7 days and 30 days,
     */
    public int mincostTickets2(int[] days, int[] costs) {
        int result = 0;
        //[day, cost]
        Queue<int[]> last7 = new LinkedList<>();
        Queue<int[]> last30 = new LinkedList<>();
        for (int day : days) {
            while (!last7.isEmpty() && last7.peek()[0] + 7 <= day) {
                last7.poll();
            }
            while (!last30.isEmpty() && last30.peek()[0] + 30 <= day) {
                last30.poll();
            }
            last7.offer(new int[]{day, result + costs[1]});
            last30.offer(new int[]{day, result + costs[2]});
            result = Math.min(result + costs[0], Math.min(last7.peek()[1], last30.peek()[1]));
        }
        return result;
    }

    /**
     * Time: O(38 * n)
     * Space: O(n)
     * 1 + 7 + 30 = 38 loop
     */

    int[] days;
    int[] costs;
    int dp[];

    public int mincostTickets3(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return dfs(0);
    }

    private int dfs(int index) {
        if (index == days.length) {
            return 0;
        }
        if (dp[index] != Integer.MAX_VALUE) {
            return dp[index];
        }
        int j = index;
        while (j < days.length && days[j] < days[index] + 1) {
            j++;
        }
        dp[index] = Math.min(dp[index], dfs(j) + costs[0]);

        j = index;
        while (j < days.length && days[j] < days[index] + 7) {
            j++;
        }
        dp[index] = Math.min(dp[index], dfs(j) + costs[1]);

        j = index;
        while (j < days.length && days[j] < days[index] + 30) {
            j++;
        }
        dp[index] = Math.min(dp[index], dfs(j) + costs[2]);
        return dp[index];
    }

}
