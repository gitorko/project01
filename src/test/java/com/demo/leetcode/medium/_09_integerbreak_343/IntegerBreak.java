package com.demo.leetcode.medium._09_integerbreak_343;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [343. Integer Break - MEDIUM](https://leetcode.com/problems/integer-break/)
 *
 * - dp, 3 math.max
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=in6QbUPMJ3I&ab_channel=NeetCode
 */
public class IntegerBreak {

    @Test
    public void test() {
        Assertions.assertEquals(36, integerBreak(10));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //start from 2
        for (int i = 2; i <= n; i++) {
            //start from 1
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }
}
