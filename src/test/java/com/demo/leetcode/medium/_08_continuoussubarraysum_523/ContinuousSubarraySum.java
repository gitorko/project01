package com.demo.leetcode.medium._08_continuoussubarraysum_523;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [523. Continuous Subarray Sum - MEDIUM](https://leetcode.com/problems/continuous-subarray-sum/)
 *
 * - pre-sum map
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=OKcrLfR-8mE&ab_channel=NeetCode
 */
public class ContinuousSubarraySum {

    @Test
    public void test1() {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Assertions.assertTrue(checkSubarraySum(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {23, 2, 4, 6, 6};
        int k = 7;
        Assertions.assertTrue(checkSubarraySum(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int total = 0;
        int remainder = 0;
        //[remainder, index]
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            remainder = total % k;
            if (prefixMap.containsKey(remainder)) {
                if (i - prefixMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                prefixMap.put(remainder, i);
            }
        }
        return false;
    }
}
