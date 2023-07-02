package com.demo.leetcode.medium._09_partitionkequalsubset_698;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [698. Partition to K Equal Sum Subsets - MEDIUM](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)
 *
 * - backtracking
 * - SIMILAR_TO: [416. Partition Equal Subset Sum - MEDIUM](https://leetcode.com/problems/partition-equal-subset-sum/)
 * - SIMILAR_TO: [473. Matchsticks to Square - MEDIUM](https://leetcode.com/problems/matchsticks-to-square/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=mBk4I0X46oI&ab_channel=NeetCode
 */
public class PartitionKEqualSubset {

    @Test
    public void test() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        Assertions.assertTrue(canPartitionKSubsets(nums, 4));
    }

    /**
     * Time: O(k*2^n)
     * Space: O(n)
     */
    boolean[] seen;
    int target = 0;
    int[] nums;

    public boolean canPartitionKSubsets(int[] input, int k) {
        nums = input;
        int sum = Arrays.stream(nums).sum();

        //optimization
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
