package com.demo.leetcode.hard._09_mindayseatorange_1553;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1553. Minimum Number of Days to Eat N Oranges - HARD](https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/)
 *
 * - bfs
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=LziQ6Qx9sks&ab_channel=NeetCode
 */
public class MinDaysEatNOranges {

    @Test
    public void test() {
        Assertions.assertEquals(4, minDays(10));
        Assertions.assertEquals(4, minDays2(10));
    }

    Map<Integer, Integer> dp;

    public int minDays(int n) {
        dp = new HashMap();
        dp.put(0, 0);
        dp.put(1, 1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int two = 1 + (n % 2) + dfs(n / 2);
        int three = 1 + (n % 3) + dfs(n / 3);
        dp.put(n, Math.min(two, three));
        return dp.get(n);
    }

    /**
     * Time: O(log(n))
     * Space: O(n)
     */
    public int minDays2(int n) {
        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int x = queue.poll();
                if (x == 1) return step;
                if (visited.add(x - 1)) queue.offer(x - 1);
                if (x % 2 == 0 && visited.add(x / 2)) queue.offer(x / 2);
                if (x % 3 == 0 && visited.add(x / 3)) queue.offer(x / 3);
            }
            step++;
        }
        return 1;
    }
}
