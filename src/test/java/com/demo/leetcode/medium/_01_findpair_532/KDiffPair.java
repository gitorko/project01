package com.demo.leetcode.medium._01_findpair_532;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [532. K-diff Pairs in an Array - MEDIUM](https://leetcode.com/problems/k-diff-pairs-in-an-array/)
 *
 * - map
 */
public class KDiffPair {

    @Test
    public void test() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        Assertions.assertEquals(2, findPairs(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * nums[i] + k = nums[j]
     */
    public int findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            numToIndex.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] + k;
            //target cant be same index, check if i is not same index
            if (numToIndex.containsKey(target) && numToIndex.get(target) != i) {
                result++;
                numToIndex.remove(target);
            }
        }
        return result;
    }
}
