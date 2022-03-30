package com.demo.leetcode.easy._09_climbstairs_70;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [70. Climbing Stairs - EASY](https://leetcode.com/problems/climbing-stairs/)
 *
 * - dynamic program, decision tree, memoization
 * - SIMILAR_TO: fibonacci, house robber
 *
 * https://www.youtube.com/watch?v=Y0lT9Fck7qI&ab_channel=NeetCode
 */
public class ClimbStairs {

    @Test
    public void test() {
        Assertions.assertEquals(3, climbStairsTopDownMemo(3));
        Assertions.assertEquals(3, climbStairsBottomUpIterative(3));
        Assertions.assertEquals(3, climbStairs(3));
        Assertions.assertEquals(1, climbStairs(1));
    }

    /**
     * Bottom up, Iterative, with memoization
     */
    public int climbStairsBottomUpIterative(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * We only need the previous 2 values and hence dont need a complete dp array
     * Iterative, with just 2 variables.
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    /**
     * Top down + memoization
     * Start from n.
     */
    int[] dp;

    public int climbStairsTopDownMemo(int n) {
        dp = new int[n + 1];
        return climbStairsHelper(n);
    }

    public int climbStairsHelper(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 2) {
            return n;
        } else if (dp[n] > 0) {
            return dp[n];
        } else {
            dp[n] = climbStairsHelper(n - 2) + climbStairsHelper(n - 1);
            return dp[n];
        }
    }
}
