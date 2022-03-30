package com.demo.leetcode.easy._09_countingbits_338;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [338. Counting Bits - EASY](https://leetcode.com/problems/counting-bits/)
 *
 * - dynamic program
 *
 * https://www.youtube.com/watch?v=RyBM56RIWrM&ab_channel=NeetCode
 */
public class CountingBits {

    @Test
    public void test() {
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, countBits(2));
    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) offset = i;
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}
