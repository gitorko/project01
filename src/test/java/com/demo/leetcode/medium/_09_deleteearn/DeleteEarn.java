package com.demo.leetcode.medium._09_deleteearn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [740. Delete and Earn - MEDIUM](https://leetcode.com/problems/delete-and-earn/)
 *
 * - bucket with sum
 * - count duplicates
 * - sort
 * - SIMILAR_TO: [198. House Robber - MEDIUM](https://leetcode.com/problems/house-robber/)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=7FCemBxvGw0&ab_channel=NeetCode
 */
public class DeleteEarn {

    @Test
    public void test() {
        int[] nums = {3, 4, 2, 4};
        Assertions.assertEquals(10, deleteAndEarn(nums));
    }

    /**
     * Time: O(n)
     * Space: O(10001)
     */
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];

        for (int num : nums)
            bucket[num] += num;

        int prev1 = 0;
        int prev2 = 0;
        //[prev1, prev2, n, n+1]
        for (int num : bucket) {
            int temp = Math.max(prev1 + num, prev2);
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
}
