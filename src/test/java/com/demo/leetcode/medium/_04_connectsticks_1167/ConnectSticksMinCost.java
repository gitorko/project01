package com.demo.leetcode.medium._04_connectsticks_1167;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1167. Minimum Cost to Connect Sticks - MEDIUM](https://leetcode.com/problems/minimum-cost-to-connect-sticks/)
 *
 * - heap, add sum back to heap
 */
public class ConnectSticksMinCost {

    @Test
    public void test1() {
        int[] nums = {2, 4, 3};
        Assertions.assertEquals(14, connectSticks(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 8, 3, 5};
        Assertions.assertEquals(30, connectSticks(nums));
    }

    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.offer(stick);
        }
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            cost += sum;
            queue.offer(sum);
        }
        return cost;
    }
}
