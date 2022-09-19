package com.demo.leetcode.hard._13_splitarraylargestsum_410;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [410. Split Array Largest Sum - HARD](https://leetcode.com/problems/split-array-largest-sum/)
 *
 * - binary search
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=YUF3_eBdzsk&ab_channel=NeetCode
 */
public class SplitArrayLargestSum {

    @Test
    public void test() {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        Assertions.assertEquals(18, splitArray(nums, m));
    }

    /**
     * Time: O(n * log(Σ∣nums∣))
     * Space: O(1)
     */
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (numGroups(nums, mid) > m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private int numGroups(int[] nums, int maxSumInGroup) {
        int groupCount = 1;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num <= maxSumInGroup) {
                curSum += num;
            } else {
                groupCount++;
                curSum = num;
            }
        }
        return groupCount;
    }
}
