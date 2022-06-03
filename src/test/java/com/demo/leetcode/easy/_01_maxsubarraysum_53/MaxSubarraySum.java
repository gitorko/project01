package com.demo.leetcode.easy._01_maxsubarraysum_53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 *
 * - reset if cur sum < 0
 * - kadane algorithm
 * - SIMILAR_TO: [121. Best Time to Buy and Sell Stock - EASY](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 *
 * https://www.youtube.com/watch?v=5WZl3MMT0Eg&ab_channel=NeetCode
 */
public class MaxSubarraySum {

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assertions.assertEquals(6, maxSubArray(nums));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    private int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //At any point if currSum is negative reset to 0.
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            maxSoFar = Math.max(maxSoFar, currSum);
        }
        return maxSoFar;
    }

}
