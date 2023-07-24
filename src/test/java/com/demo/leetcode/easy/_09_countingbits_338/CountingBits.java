package com.demo.leetcode.easy._09_countingbits_338;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [338. Counting Bits - EASY](https://leetcode.com/problems/counting-bits/)
 *
 * - 1D DP
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=RyBM56RIWrM&ab_channel=NeetCode
 */
public class CountingBits {

    @Test
    public void test() {
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, countBits(2));
        Assertions.assertArrayEquals(expected, countBits2(2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        for (int i = 1; i < n + 1; i++) {
            //power of 2 is when changes
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    /**
     * Time: O(n * log(n))
     * Space: O(1)
     */
    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num = num / 2;
            }
            result[i] = count;
        }
        return result;
    }
}
