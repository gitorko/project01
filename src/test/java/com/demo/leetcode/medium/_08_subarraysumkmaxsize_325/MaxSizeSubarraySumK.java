package com.demo.leetcode.medium._08_subarraysumkmaxsize_325;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [325. Maximum Size Subarray Sum Equals k - MEDIUM](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
 * https://www.lintcode.com/problem/maximum-size-subarray-sum-equals-k
 *
 * - prefix sum map, 0 has value -1
 * - SIMILAR_TO: [560. Subarray Sum Equals K - MEDIUM](https://leetcode.com/problems/subarray-sum-equals-k/)
 *
 */
public class MaxSizeSubarraySumK {

    @Test
    public void test() {
        int[] prices = {2, 5, 7, 8, 9, 18, 2, 2};
        Assertions.assertEquals(3, maxSubArrayLen(prices, 14));
    }

    /**
     * Time O(N)
     * space O(1)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int curSum = 0;
        int result = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int diff = curSum - k;
            if (prefixToIndex.containsKey(diff)) {
                result = Math.max(result, i - prefixToIndex.get(diff));
            }
            prefixToIndex.putIfAbsent(curSum, i);
        }
        return result;
    }

}
