package com.demo.leetcode.medium._01_maxsumcirclesubarray_918;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [918. Maximum Sum Circular Subarray - MEDIUM](https://leetcode.com/problems/maximum-sum-circular-subarray/)
 *
 * - kadane
 * - SIMILAR_TO: [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 *
 * https://www.youtube.com/watch?v=fxT9KjakYPM&ab_channel=NeetCodeIO
 */
public class MaxSumCircularSubarray {

    @Test
    public void test1() {
        int[] nums = {1, -2, 3, -2};
        Assertions.assertEquals(3, maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}
