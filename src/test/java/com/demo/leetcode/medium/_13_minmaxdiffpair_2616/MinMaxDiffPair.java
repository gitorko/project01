package com.demo.leetcode.medium._13_minmaxdiffpair_2616;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

/**
 * [2616. Minimize the Maximum Difference of Pairs - MEDIUM](https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/)
 *
 * https://www.youtube.com/watch?v=lf1Pxg7IrzQ&ab_channel=NeetCodeIO
 */
public class MinMaxDiffPair {

    public void test() {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        Assertions.assertEquals(1, minimizeMax(nums, p));
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int k = 0;
            for (int i = 1; i < n && k < p; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    k++;
                    i++;
                }
            }
            if (k >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
