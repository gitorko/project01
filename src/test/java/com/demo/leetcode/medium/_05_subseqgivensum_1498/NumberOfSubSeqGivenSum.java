package com.demo.leetcode.medium._05_subseqgivensum_1498;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1498. Number of Subsequences That Satisfy the Given Sum Condition - MEDIUM](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
 *
 * - sort
 * - two pointer (left is min, right is max)
 * - math - pre calculate powers
 *
 * PRACTICE: P1
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
     * Time: O(nlogn)
     * Space: O(n)
     */
    public int numSubseq(int[] nums, int target) {
        int kMod = (int) 1e9 + 7;
        int n = nums.length;
        int result = 0;
        int[] pows = new int[n];
        pows[0] = 1;

        for (int i = 1; i < n; i++)
            pows[i] = pows[i - 1] * 2 % kMod;

        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
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
