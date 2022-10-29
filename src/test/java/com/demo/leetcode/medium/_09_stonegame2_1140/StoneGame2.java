package com.demo.leetcode.medium._09_stonegame2_1140;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1140. Stone Game II - MEDIUM](https://leetcode.com/problems/stone-game-ii/)
 *
 * https://www.youtube.com/watch?v=I-z-u0zfQtg&ab_channel=NeetCodeIO
 */
public class StoneGame2 {

    @Test
    public void test() {
        int[] piles = {2, 7, 9, 4, 4};
        Assertions.assertEquals(10, stoneGameII(piles));
    }

    /**
     * Time: O(n^3)
     * Space: O(n^2)
     */
    int[] piles;
    Map<String, Integer> dp;

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        dp = new HashMap<>();
        return helper(true, 0, 1);
    }

    public int helper(boolean alice, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        String key = alice + "-" + i + "-" + m;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int result;
        if (alice) {
            result = 0;
        } else {
            result = Integer.MAX_VALUE;
        }
        int total = 0;
        for (int j = 1; j < 2 * m + 1; j++) {
            if (i + j > piles.length) {
                break;
            }
            total += piles[i + j - 1];
            if (alice) {
                result = Math.max(result, total + helper(!alice, i + j, Math.max(m, j)));
            } else {
                result = Math.min(result, helper(!alice, i + j, Math.max(m, j)));
            }
        }
        dp.put(key, result);
        return result;

    }
}
