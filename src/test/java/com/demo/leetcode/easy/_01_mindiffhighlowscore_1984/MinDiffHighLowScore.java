package com.demo.leetcode.easy._01_mindiffhighlowscore_1984;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *[1984. Minimum Difference Between Highest and Lowest of K Scores - EASY](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/)
 *
 * - sliding window
 *
 * https://www.youtube.com/watch?v=JU5XdBZZtlk&ab_channel=NeetCode
 */
public class MinDiffHighLowScore {

    @Test
    public void test() {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        Assertions.assertEquals(2, minimumDifference(nums, k));
    }

    /**
     * Time: O(n log(n))
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            result = Math.min(result, nums[right++] - nums[left++]);
        }
        return result;
    }
}
