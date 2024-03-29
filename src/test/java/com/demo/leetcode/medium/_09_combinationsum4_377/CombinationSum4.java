package com.demo.leetcode.medium._09_combinationsum4_377;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [377. Combination Sum IV - MEDIUM](https://leetcode.com/problems/combination-sum-iv/)
 *
 * - 1D DP
 * - SIMILAR_TO: [322. Coin Change - MEDIUM](https://leetcode.com/problems/coin-change/)
 * - SIMILAR_TO: [279. Perfect Squares - MEDIUM](https://leetcode.com/problems/perfect-squares/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=dw2nMCxG0ik&ab_channel=NeetCode
 */
public class CombinationSum4 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(7, combinationSum4(nums, 4));
        Assertions.assertEquals(7, combinationSum4bottomUp(nums, 4));
    }

    /**
     * Top Down
     * Time: O(m*n)
     * Space: O(m*n)
     */
    int[] dp;
    int[] nums;

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return dfs(target);
    }

    private int dfs(int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += dfs(target - nums[i]);
            }
        }
        dp[target] = result;
        return result;
    }

    /**
     * Bottom up
     * Time: O(m*n) m is target value, n is input
     * Space: O(m*n)
     */
    public int combinationSum4bottomUp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                //if its not a negative value
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
