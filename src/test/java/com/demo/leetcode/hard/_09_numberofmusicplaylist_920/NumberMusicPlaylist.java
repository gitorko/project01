package com.demo.leetcode.hard._09_numberofmusicplaylist_920;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [920. Number of Music Playlists - HARD](https://leetcode.com/problems/number-of-music-playlists)
 *
 * https://www.youtube.com/watch?v=gk4qzZSmyrs&ab_channel=NeetCodeIO
 */
public class NumberMusicPlaylist {

    @Test
    public void test() {
        int n = 3;
        int goal = 3;
        int k = 1;
        Assertions.assertEquals(6, numMusicPlaylists(n, goal, k));
    }

    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = (int) (1e9 + 7);
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                }
            }
        }
        return (int) dp[goal][n];
    }
}
