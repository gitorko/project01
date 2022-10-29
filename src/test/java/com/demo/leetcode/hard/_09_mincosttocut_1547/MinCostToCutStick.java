package com.demo.leetcode.hard._09_mincosttocut_1547;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1547. Minimum Cost to Cut a Stick - HARD](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/)
 *
 * https://www.youtube.com/watch?v=EVxTO5I0d7w&ab_channel=NeetCodeIO
 */
public class MinCostToCutStick {

    @Test
    public void test() {
        int n = 9, cuts[] = {5, 6, 1, 4, 2};
        Assertions.assertEquals(22, minCost(n, cuts));
    }

    /**
     * Time: O(m * n^2) , m is length of cut array.
     * Space: O(n)
     */
    Map<String, Integer> dp;
    int[] cuts;

    public int minCost(int n, int[] cuts) {
        dp = new HashMap<>();
        this.cuts = cuts;
        return dfs(0, n);
    }

    private int dfs(int left, int right) {
        //cant cut any further
        if (right - left == 1) {
            return 0;
        }
        String key = left + "-" + right;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int result = Integer.MAX_VALUE;
        for (int c : cuts) {
            if (left < c && c < right) {
                result = Math.min(result, (right - left) + dfs(left, c) + dfs(c, right));
            }
        }
        result = (result == Integer.MAX_VALUE ? 0 : result);
        dp.put(key, result);
        return result;
    }

}


