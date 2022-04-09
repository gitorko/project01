package com.demo.leetcode.medium._09_targetsum_494;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [494. Target Sum - MEDIUM](https://leetcode.com/problems/target-sum/)
 *
 * - dp of index+total, recursion
 * - return 1 or 0 if true
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=g0npyaQtAQM&ab_channel=NeetCode
 */
public class TargetSum {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        Assertions.assertEquals(5, findTargetSumWays(nums, target));
    }

    /**
     * Time: O(sum(nums) * n)
     * Space: O(sum(nums) * n)
     */
    int[] nums;
    int target;
    Map<String, Integer> dp = new HashMap();

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return backtrack(0, 0);
    }

    public int backtrack(int i, int total) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        String key = i + "_" + total;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        dp.put(key, backtrack(i + 1, total + nums[i]) + backtrack(i + 1, total - nums[i]));
        return dp.get(key);
    }

}
