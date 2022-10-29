package com.demo.leetcode.medium._09_solvingquestion_2140;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2140. Solving Questions With Brainpower - MEDIUM](https://leetcode.com/problems/solving-questions-with-brainpower/)
 *
 * - DP (bottom up)
 *
 * https://www.youtube.com/watch?v=D7TD_ArkfkA&ab_channel=NeetCodeIO
 */
public class SolveQuestion {

    @Test
    public void test() {
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        Assertions.assertEquals(5, mostPoints(questions));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            int nextQuestion = i + questions[i][1] + 1;
            dp[i] = Math.max(questions[i][0] + (nextQuestion < n ? dp[nextQuestion] : 0), dp[i + 1]);
        }
        return dp[0];
    }
}
