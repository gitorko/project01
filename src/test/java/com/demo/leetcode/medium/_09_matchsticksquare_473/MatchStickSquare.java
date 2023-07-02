package com.demo.leetcode.medium._09_matchsticksquare_473;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [473. Matchsticks to Square - MEDIUM](https://leetcode.com/problems/matchsticks-to-square/)
 *
 * - backtracking
 * - SIMILAR_TO: [698. Partition to K Equal Sum Subsets - MEDIUM](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
 *
 * https://www.youtube.com/watch?v=hUe0cUKV-YY&ab_channel=NeetCode
 */
public class MatchStickSquare {

    @Test
    public void test1() {
        int[] nums = {1, 1, 2, 2, 2};
        Assertions.assertTrue(makesquare(nums));
    }

    @Test
    public void test2() {
        int[] nums = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        Assertions.assertTrue(makesquare(nums));
    }

    /**
     * Time: O(k*2^n)
     * Space: O(n)
     */
    boolean[] seen;
    int target = 0;
    int[] nums;

    public boolean makesquare(int[] matchsticks) {
        return canPartitionKSubsets(matchsticks, 4);
    }

    private boolean canPartitionKSubsets(int[] input, int k) {
        nums = input;
        int sum = Arrays.stream(nums).sum();

        //optimization of sorting in reverse order
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        if (sum % k != 0) {
            return false;
        }

        target = sum / k; // each subset's target sum
        seen = new boolean[nums.length];
        return backtrack(0, k, 0);
    }

    private boolean backtrack(int i, int k, int subsetSum) {
        if (k == 0) {
            return true;
        }
        if (subsetSum == target) {
            return backtrack(0, k - 1, 0);
        }
        for (int j = i; j < nums.length; j++) {
            if (seen[j] || subsetSum + nums[j] > target) {
                continue;
            }
            seen[j] = true;
            if (backtrack(j + 1, k, subsetSum + nums[j])) {
                return true;
            }
            seen[j] = false;
        }
        return false;
    }
}
