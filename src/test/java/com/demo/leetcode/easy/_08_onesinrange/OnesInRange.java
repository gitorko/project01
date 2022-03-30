package com.demo.leetcode.easy._08_onesinrange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Ones in Range - EASY]()
 *
 * - prefix sum
 * - SIMILAR_TO: [303. Range Sum Query - Immutable - EASY](https://leetcode.com/problems/range-sum-query-immutable/)
 *
 * PRACTICE
 */
public class OnesInRange {

    @Test
    public void test() {
        int[] nums = {0, 1, 1, 1, 0, 0};
        NumArray numArray = new NumArray(nums);
        Assertions.assertEquals(3, numArray.howManyOnesInRange(0, 3));
        Assertions.assertEquals(0, numArray.howManyOnesInRange(0, 0));
        Assertions.assertEquals(1, numArray.howManyOnesInRange(3, 5));
    }

    /**
     * You have a huge array of integers containing only 0's and 1's.
     * Write an algorithm that finds the number of 1's found in the array in a specific range.
     */
    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < preSum.length; i++)
                preSum[i] = nums[i] + preSum[i - 1];
        }

        public int howManyOnesInRange(int left, int right) {
            if (left == 0) return preSum[right];
            return preSum[right] - preSum[left - 1];
        }

    }
}
