package com.demo.leetcode.medium._05_minsubarraysumsize_209;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [209. Minimum Size Subarray Sum - MEDIUM](https://leetcode.com/problems/minimum-size-subarray-sum/)
 *
 * - sliding window
 * - remember to reduce total
 * - use Integer.MAX_VALUE
 * - brute force 2 for loop takes O(n^2)
 *
 * https://www.youtube.com/watch?v=aYqYMIqZx5s&ab_channel=NeetCode
 */
public class MinSizeSubArraySum {

    @Test
    public void test() {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        Assertions.assertEquals(2, minSubArrayLen(target, nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            //most cases you will write if here, remember to use while.
            while (total >= target) {
                min = Math.min(right - left + 1, min);
                total = total - nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
