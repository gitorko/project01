package com.demo.leetcode.medium._05_subseqgivensum_1498;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1498. Number of Subsequences That Satisfy the Given Sum Condition - MEDIUM](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
 *
 * - sort
 * - two pointer (left is min, right is max)
 * - math pre-calculated powers
 * - PRACTICE: P1
 * - MISTAKES: Likely to forget mod
 *
 * https://www.youtube.com/watch?v=xCsIkPLS4Ls&ab_channel=NeetCode
 */
public class NumberOfSubSeqGivenSum {

    @Test
    public void test() {
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        Assertions.assertEquals(4, numSubseq(nums, target));
    }

    /**
     * Time: O(n * log(n))
     * Space: O(n)
     */
    public int numSubseq(int[] nums, int target) {
        int kMod = (int) 1e9 + 7;
        int result = 0;

        //2^n power lookup table
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % kMod;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result += pows[right - left];
                result %= kMod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
