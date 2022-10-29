package com.demo.leetcode.hard._09_stonegame3_1406;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1406. Stone Game III - HARD](https://leetcode.com/problems/stone-game-iii/)
 *
 * https://www.youtube.com/watch?v=HsLG5QW9CFQ&ab_channel=NeetCodeIO
 */
public class StoneGame3 {

    @Test
    public void test() {
        int[] stoneValue = {1, 2, 3, 7};
        Assertions.assertEquals("Bob", stoneGameIII(stoneValue));
    }

    Map<Integer, Integer> dp;
    int[] stoneValue;

    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        dp = new HashMap<>();
        int result = helper(0);
        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int helper(int i) {
        if (i == stoneValue.length) {
            return 0;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int result = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            int sum = 0;
            for (int k = i; k < j + 1; k++) {
                sum += stoneValue[k];
            }
            result = Math.max(result, sum - helper(j + 1));
        }
        dp.put(i, result);
        return result;
    }
}
