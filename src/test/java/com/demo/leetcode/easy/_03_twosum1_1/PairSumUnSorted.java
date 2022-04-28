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
 *
 * https://www.youtube.com/watch?v=KLlXCFG5TnA&ab_channel=NeetCode
 */
class PairSumUnSorted {

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, onePass(nums, 9));
        Assertions.assertArrayEquals(expected, twoPass(nums, 9));
    }

    /**
     * Two Pass
     * Beware that the complement must not be nums[i] itself!
     * eg: [2,1,5,3], target=4
     * 4-2=2, but 2 is present only once. Hence one pass is better.
     *
     * If you do 2 pass then you need to be aware of this extra check, in one pass its not an issue.
     * Time: O(N)
     * Space: O(N)
     */
    public int[] twoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //Extra check to see if the complement is not the number itself.
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }


    /**
     * One Pass, complement is key, index is value.
     * Time: O(N)
     * Space: O(N)
     */
    public int[] onePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
