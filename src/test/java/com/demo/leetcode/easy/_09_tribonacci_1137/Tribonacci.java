package com.demo.leetcode.easy._09_tribonacci_1137;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1137. N-th Tribonacci Number - EASY](https://leetcode.com/problems/n-th-tribonacci-number/)
 *
 * https://www.youtube.com/watch?v=3lpNp5Ojvrw&ab_channel=NeetCodeIO
 */
public class Tribonacci {

    @Test
    public void test() {
        Assertions.assertEquals(4, tribonacci(4));
        Assertions.assertEquals(1389537, tribonacci(25));

        Assertions.assertEquals(4, tribonacci2(4));
        Assertions.assertEquals(1389537, tribonacci2(25));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        for (int i = 3; i < n + 1; i++) {
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int tribonacci2(int n) {
        int dp[] = {0, 1, 1};
        for (int i = 3; i < n + 1; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[n % 3];
    }
}
