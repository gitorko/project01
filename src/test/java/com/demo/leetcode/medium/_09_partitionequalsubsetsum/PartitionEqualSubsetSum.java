package com.demo.leetcode.medium._09_partitionequalsubsetsum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [416. Partition Equal Subset Sum - MEDIUM](https://leetcode.com/problems/partition-equal-subset-sum/)
 *
 * - two set
 * - 0/1 knapsack
 * - SIMILAR_TO: [698. Partition to K Equal Sum Subsets - MEDIUM](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
 * - SIMILAR_TO: [SubSet Sum - MEDIUM]()
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=IsvocB5BJhw&ab_channel=NeetCode
 */
public class PartitionEqualSubsetSum {

    @Test
    public void test1() {
        int[] nums = {5, 3, 8};
        Assertions.assertTrue(canPartition(nums));
        Assertions.assertTrue(canPartition2(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 5, 11, 5};
        Assertions.assertTrue(canPartition(nums));
        Assertions.assertTrue(canPartition2(nums));
    }

    /**
     * Time: O(n * sum(nums))
     * Space: O(sum(nums))
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }

    /**
     * Time: O(n * k) ,k is target
     * Space: O(n * k)
     */
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        return knapsack(nums, sum / 2);
    }

    private boolean knapsack(int[] nums, int subsetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][subsetSum + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < subsetSum + 1; j++) {
                int currVal = nums[i - 1];
                if (currVal > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - currVal];
                }
            }
        }
        return dp[n][subsetSum];
    }

}
