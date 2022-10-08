package com.demo.leetcode.medium._08_subarraysumk_560;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [560. Subarray Sum Equals K - MEDIUM](https://leetcode.com/problems/subarray-sum-equals-k/)
 *
 * - prefix sum map, 0 has value 1
 * - cant do sliding window as input has negative
 * - SIMILAR_TO: [325. Maximum Size Subarray Sum Equals k - MEDIUM](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=fFVZt-6sgyo&ab_channel=NeetCode
 */
public class SubArraySumK {

    @Test
    public void test() {
        int[] nums = {1, 1, 1};
        int k = 2;
        Assertions.assertEquals(2, subarraySum(nums, k));
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        int k = 3;
        Assertions.assertEquals(2, subarraySum(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        int result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int diff = curSum - k;
            if (preSum.containsKey(diff)) {
                result += preSum.get(diff);
            }
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }
}
