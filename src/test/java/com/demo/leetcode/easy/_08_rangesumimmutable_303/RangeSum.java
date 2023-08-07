package com.demo.leetcode.easy._08_rangesumimmutable_303;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [303. Range Sum Query - Immutable - EASY](https://leetcode.com/problems/range-sum-query-immutable/)
 *
 * - prefix sum
 * - SIMILAR_TO: [Ones in Range - MEDIUM]()
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=2pndAmo_sMA&ab_channel=NeetCodeIO
 */
public class RangeSum {

    @Test
    public void test() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        Assertions.assertEquals(1, numArray.sumRange(0, 2));
        Assertions.assertEquals(-1, numArray.sumRange(2, 5));
        Assertions.assertEquals(-3, numArray.sumRange(0, 5));
    }

    /**
     * Time: O(1)
     * Space: O(n)
     */
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = nums[i] + preSum[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return preSum[right];
            }
            return preSum[right] - preSum[left - 1];
        }
    }

}
