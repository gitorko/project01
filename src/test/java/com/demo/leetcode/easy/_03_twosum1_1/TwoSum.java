package com.demo.leetcode.easy._03_twosum1_1;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1. Two Sum - EASY](https://leetcode.com/problems/two-sum/)
 *
 *  - option 1: use hashmap - two pass, edge case to check if complement is number itself.
 *  - option 2: use hashmap - one pass, complement.
 *  - SIMILAR_TO: [167. Two Sum II - Input Array Is Sorted - MEDIUM](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
 *  - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=KLlXCFG5TnA&ab_channel=NeetCode
 */
class TwoSum {

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, twoSum(nums, 9));
        Assertions.assertArrayEquals(expected, twoSum2(nums, 9));
    }

    /**
     * One Pass
     * Time: O(n)
     * Space: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        //[diff, index]
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diffMap.containsKey(diff)) {
                return new int[]{diffMap.get(diff), i};
            }
            diffMap.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * Two Pass
     * Beware that the complement must not be nums[i] itself!
     * eg: [2,1,5,3], target=4
     * 4-2=2, but 2 is present only once. Hence one pass is better.
     *
     * If you do 2 pass then you need to be aware of this extra check, in one pass it's not an issue.
     * Time: O(n)
     * Space: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            diffMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //Extra check to see if the complement is not the number itself.
            if (diffMap.containsKey(complement) && diffMap.get(complement) != i) {
                return new int[]{i, diffMap.get(complement)};
            }
        }
        return new int[]{};
    }

}
