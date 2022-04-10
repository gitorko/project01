package com.demo.leetcode.medium._09_houserobber2_213;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [213. House Robber II - MEDIUM](https://leetcode.com/problems/house-robber-ii/)
 *
 * - 0..n-2,1..n-1
 * - rob = max (num[i] + rob(i-2), rob(i-1))
 *
 * https://www.youtube.com/watch?v=rWAJCfYYOvM&ab_channel=NeetCode
 */
public class HouseRob2 {

    @Test
    public void test() {
        int[] nums = {2, 3, 2};
        Assertions.assertEquals(3, rob(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    int[] nums;

    public int rob(int[] input) {
        nums = input;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robBottomUp(0, nums.length - 2), robBottomUp(1, nums.length - 1));
    }

    public int robBottomUp(int left, int right) {
        int rob1 = 0;
        int rob2 = 0;
        //[rob1, rob2, n, n+1]
        for (int i = left; i <= right; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

}
