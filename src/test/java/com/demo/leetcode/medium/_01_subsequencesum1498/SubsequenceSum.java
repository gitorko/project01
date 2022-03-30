package com.demo.leetcode.medium._01_subsequencesum1498;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1498. Number of Subsequences That Satisfy the Given Sum Condition - MEDIUM](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
 *
 * - similar to 2 sum
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=xCsIkPLS4Ls&ab_channel=NeetCode
 */
public class SubsequenceSum {

    @Test
    public void test() {
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        Assertions.assertEquals(4, numSubseq(nums, target));
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int l = 0;
        int r = nums.length - 1;
        int mod = (int) 1e9 + 7;

        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++)
            pows[i] = pows[i - 1] * 2 % mod;

        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                result = (result + pows[r - l]) % mod;
                l++;
            }
        }
        return result;
    }
}
