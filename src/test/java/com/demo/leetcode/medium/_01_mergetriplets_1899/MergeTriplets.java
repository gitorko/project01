package com.demo.leetcode.medium._01_mergetriplets_1899;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1899. Merge Triplets to Form Target Triplet - MEDIUM](https://leetcode.com/problems/merge-triplets-to-form-target-triplet/)
 *
 * - remove greater than target
 *
 * https://www.youtube.com/watch?v=kShkQLQZ9K4&ab_channel=NeetCode
 */
public class MergeTriplets {

    @Test
    public void test() {
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};
        Assertions.assertTrue(mergeTriplets(triplets, target));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merged = new int[target.length];
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;
            for (int i = 0; i < target.length; i++)
                merged[i] = Math.max(merged[i], t[i]);
        }
        return Arrays.equals(merged, target);
    }
}
