package com.demo.leetcode.easy._01_maxone_485;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [485. Max Consecutive Ones - EASY](https://leetcode.com/problems/max-consecutive-ones/)
 *
 * - reset to when 0 encountered
 */
public class MaxOne {

    @Test
    public void test() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        Assertions.assertEquals(3, findMaxConsecutiveOnes(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int sum = 0;
        for (int num : nums)
            if (num == 1)
                ans = Math.max(ans, ++sum);
            else
                sum = 0;
        return ans;
    }
}
