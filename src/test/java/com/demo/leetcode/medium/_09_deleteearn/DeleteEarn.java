package com.demo.leetcode.medium._09_deleteearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public void test1() {
        int[] nums = {3, 4, 2, 4};
        Assertions.assertEquals(10, deleteAndEarn(nums));
        Assertions.assertEquals(10, deleteAndEarn2(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 3, 3, 3, 4};
        Assertions.assertEquals(9, deleteAndEarn(nums));
        Assertions.assertEquals(9, deleteAndEarn2(nums));
    }

    /**
     * Time: O(n)
     * Space: O(10001)
     * without sorting
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

    /**
     * Time: O(n log(n))
     * Space: O(n)
     * with sorting
     */
    public int deleteAndEarn2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int prev1 = 0;
        int prev2 = 0;
        //[prev1, prev2, n, n+1]
        for (int i = 0; i < nums.length; i++) {
            int curEarn = nums[i] * countMap.get(nums[i]);
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                int temp = Math.max(prev1 + curEarn, prev2);
                prev1 = prev2;
                prev2 = temp;
            } else {
                int temp = prev2 + curEarn;
                prev1 = prev2;
                prev2 = temp;
            }
        }
        return prev2;
    }
}
