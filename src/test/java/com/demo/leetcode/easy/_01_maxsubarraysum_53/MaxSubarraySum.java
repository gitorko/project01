package com.demo.leetcode.easy._01_maxsubarraysum_53;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 *
 * - reset if cur sum < 0
 * - kadane algorithm
 * - SIMILAR_TO: [121. Best Time to Buy and Sell Stock - EASY](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 * - SIMILAR_TO: [152. Maximum Product Subarray - MEDIUM](https://leetcode.com/problems/maximum-product-subarray/)
 * - PRACTICE: P3
 * - MISTAKES: Reset must be done before not after addition
 *
 * https://www.youtube.com/watch?v=5WZl3MMT0Eg&ab_channel=NeetCode
 */
public class MaxSubarraySum {

    @Test
    public void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assertions.assertEquals(6, maxSubArray(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-1};
        Assertions.assertEquals(-1, maxSubArray(nums));
    }

    @Test
    public void test3() {
        int[] nums = {-6, -1, -2, -3, -4, -5};
        Assertions.assertEquals(-1, maxSubArray(nums));
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    private int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (int n : nums) {
            //At any point if currSum is negative reset to 0.
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

}
