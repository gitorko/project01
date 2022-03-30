package com.demo.leetcode.medium._05_maxpointscard_1423;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1423. Maximum Points You Can Obtain from Cards - MEDIUM](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
 *
 * - sliding window, sum right first
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=TsA4vbtfCvo&ab_channel=NeetCode
 */
public class MaxPointsCards {

    @Test
    public void test() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        Assertions.assertEquals(12, maxScore(cardPoints, k));
    }

    /**
     * Time: O(k)
     * Space: O(1)
     */
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length - k;
        int sum = 0;

        for (int i = right; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        int maxSum = sum;

        while (right < cardPoints.length) {
            sum = sum + cardPoints[left++] - cardPoints[right++];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
