package com.demo.leetcode.medium._09_eggdrop_1884;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1884. Egg Drop With 2 Eggs and N Floors - MEDIUM](https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/)
 *
 * - dp + binary search
 *
 * https://www.youtube.com/watch?v=NGtt7GJ1uiM&ab_channel=TED-Ed
 * https://www.youtube.com/watch?v=KVfxgpI3Tv0&ab_channel=GeeksforGeeks
 */
public class SuperEggDrop {

    @Test
    public void test() {
        Assertions.assertEquals(2, superEggDrop(2, 2));
        Assertions.assertEquals(14, superEggDrop(2, 100));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     */
    private int[][] dp;

    private int superEggDrop(int K, int N) {
        // dp[k][n] := min # of moves to know F with k eggs and n floors
        dp = new int[K + 1][N + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return drop(K, N);
    }

    private int drop(int k, int n) {
        if (k == 0) // no eggs -> done
            return 0;
        if (k == 1) // one egg -> drop from 1-th floor to n-th floor
            return n;
        if (n == 0) // no floor -> done
            return 0;
        if (n == 1) // one floor -> drop from that floor
            return 1;
        if (dp[k][n] != -1)
            return dp[k][n];

        // broken[i] := drop(k - 1, i - 1) is increasing w/ i
        // unbroken[i] := drop(k,     n - i) is decreasing w/ i
        // dp[k][n] := 1 + min(max(broken[i], unbroken[i])), 1 <= i <= n
        // find the first index i s.t broken[i] >= unbroken[i],
        // which minimizes max(broken[i], unbroken[i])

        int left = 1;
        int right = n + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int broken = drop(k - 1, mid - 1);
            int unbroken = drop(k, n - mid);
            if (broken >= unbroken)
                right = mid;
            else
                left = mid + 1;
        }
        return dp[k][n] = 1 + drop(k - 1, left - 1);
    }
}
