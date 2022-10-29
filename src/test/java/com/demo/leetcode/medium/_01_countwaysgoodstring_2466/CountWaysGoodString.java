package com.demo.leetcode.medium._01_countwaysgoodstring_2466;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2466. Count Ways To Build Good Strings - MEDIUM](https://leetcode.com/problems/count-ways-to-build-good-strings/)
 *
 * - backtracking
 *
 * https://www.youtube.com/watch?v=JKpVHG2mhbk&ab_channel=NeetCodeIO
 */
public class CountWaysGoodString {

    @Test
    public void test() {
        int low = 3, high = 3, zero = 1, one = 1;
        Assertions.assertEquals(8, countGoodStrings(low, high, zero, one));
    }

    int[] dp;
    int modVal = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        int result = 0;
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        for (int i = low; i <= high; i++) {
            result = ((result % modVal) + dfs(i, one, zero)) % modVal;
        }
        return result;
    }

    public int dfs(int target, int one, int zero) {
        // good string
        if (target == 0) {
            return 1;
        }
        // not a good string
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int sum = dfs(target - one, one, zero) + dfs(target - zero, one, zero);
        dp[target] = sum % modVal;
        return dp[target];
    }
}
