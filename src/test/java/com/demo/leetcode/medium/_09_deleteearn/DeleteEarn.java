package com.demo.leetcode.medium._09_deleteearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [740. Delete and Earn - MEDIUM](https://leetcode.com/problems/delete-and-earn/)
 *
 * - 1 DP
 * - sort
 * - SIMILAR_TO: [198. House Robber - MEDIUM](https://leetcode.com/problems/house-robber/)
 * - PRACTICE: P2
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
     * Time: O(n*log(n))
     * Space: O(n)
     * with sorting
     */
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int earn1 = 0;
        int earn2 = 0;
        int temp;
        // [earn1, earn2, i ,n]
        for (int i = 0; i < nums.length; i++) {
            int curEarn = nums[i] * countMap.get(nums[i]);
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                temp = Math.max(earn1 + curEarn, earn2);
            } else {
                temp = earn2 + curEarn;
            }
            earn1 = earn2;
            earn2 = temp;
        }
        return earn2;
    }

    /**
     * Time: O(n)
     * Space: O(10001)
     * without sorting
     */
    public int deleteAndEarn2(int[] nums) {
        int[] bucket = new int[10001];
        for (int num : nums) {
            bucket[num] += num;
        }
        int prev1 = 0;
        int prev2 = 0;
        // [prev1, prev2, i, n]
        // will iterate over all numbers from 0 to 10001
        for (int num : bucket) {
            int temp = Math.max(prev1 + num, prev2);
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
}
