package com.demo.leetcode.medium._09_bestteamnoconflict_1626;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1626. Best Team With No Conflicts - MEDIUM](https://leetcode.com/problems/best-team-with-no-conflicts/)
 *
 * - SIMILAR_TO: [300. Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/longest-increasing-subsequence/)
 *
 * https://www.youtube.com/watch?v=7kURH3btcV4&ab_channel=NeetCodeIO
 */
public class BestTeamNoConflict {

    @Test
    public void test1() {
        int[] scores = {1, 3, 5, 10, 15};
        int[] ages = {1, 2, 3, 4, 5};
        Assertions.assertEquals(34, bestTeamScore(scores, ages));
    }

    @Test
    public void test2() {
        int[] scores = {4, 5, 6, 5};
        int[] ages = {2, 1, 2, 1};
        Assertions.assertEquals(16, bestTeamScore(scores, ages));
    }

    @Test
    public void test3() {
        int[] scores = {1};
        int[] ages = {4};
        Assertions.assertEquals(1, bestTeamScore(scores, ages));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        //[score,age]
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }
        // sort first by score then by age
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //[score]
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = pairs[i][0];
        }
        int result = dp[0];
        //start from second element
        for (int i = 1; i < n; i++) {
            int mScore = pairs[i][0];
            int mAge = pairs[i][1];
            for (int j = 0; j < i; j++) {
                int score = pairs[j][0];
                int age = pairs[j][1];
                if (mAge >= age) {
                    dp[i] = Math.max(dp[i], mScore + dp[j]);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
