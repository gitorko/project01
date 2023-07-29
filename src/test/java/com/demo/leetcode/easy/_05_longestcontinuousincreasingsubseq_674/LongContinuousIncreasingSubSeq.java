package com.demo.leetcode.easy._05_longestcontinuousincreasingsubseq_674;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [674. Longest Continuous Increasing Subsequence - EASY](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)
 *
 * - two pointer, sliding window
 * - SIMILAR_TO: [128. Longest Consecutive Sequence - MEDIUM](https://leetcode.com/problems/longest-consecutive-sequence/)
 */
public class LongContinuousIncreasingSubSeq {

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 4, 7};
        Assertions.assertEquals(3, findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (right > 0 && nums[right] <= nums[right - 1]) {
                left = right;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
