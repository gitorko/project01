package com.demo.leetcode.hard._09_rearrangestickswithk_1866;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1866. Number of Ways to Rearrange Sticks With K Sticks Visible - HARD](https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/)
 *
 * https://www.youtube.com/watch?v=O761YBjGxGA&ab_channel=NeetCode
 */
public class RearrangeSticks {

    @Test
    public void test1() {
        int n = 3, k = 2;
        Assertions.assertEquals(3, rearrangeSticks(n, k));
    }

    @Test
    public void test2() {
        int n = 20, k = 11;
        Assertions.assertEquals((int) 647427950, rearrangeSticks(n, k));
    }

    /**
     * Time: O(n * k)
     * Space: O(1)
     */
    int dp[][] = new int[1001][1001];
    int modVal = (int) (1e9 + 7);

    public int rearrangeSticks(int n, int k) {
        if (n == k) {
            return 1;
        }
        if (k == 0 || n == 0) {
            return 0;
        }
        if (dp[n][k] == 0) {
            dp[n][k] = (int) ((1L * rearrangeSticks(n - 1, k - 1) + 1L * (n - 1) * rearrangeSticks(n - 1, k)) % modVal);
        }
        return dp[n][k];
    }
}
