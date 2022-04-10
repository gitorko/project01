package com.demo.leetcode.medium._09_numberoflongestincreasingsubseq_673;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [673. Number of Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
 *
 * - start from reverse, LIS
 * - map dp(count+length)
 * - local max length, local max count
 * - SIMILAR_TO: [300. Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/longest-increasing-subsequence/)
 *
 * PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Tuc-rjJbsXU&ab_channel=NeetCode
 */
public class NumberOfLongestIncreasingSubseq {

    @Test
    public void test1() {
        int nums[] = {1, 3, 5, 4, 7};
        Assertions.assertEquals(2, findNumberOfLIS(nums));
    }

    @Test
    public void test2() {
        int nums[] = {2, 2, 2, 2, 2};
        Assertions.assertEquals(5, findNumberOfLIS(nums));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int findNumberOfLIS(int[] nums) {
        Map<Integer, int[]> dp = new HashMap<>();
        int maxCount = 0;
        int maxLen = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            //max will be the number itself so always init to 1
            int localMaxLen = 1;
            int localMaxCount = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int length = dp.get(j)[0];
                    int count = dp.get(j)[1];
                    if (length + 1 > localMaxLen) {
                        localMaxLen = length + 1;
                        localMaxCount = count;
                    } else if (length + 1 == localMaxLen) {
                        localMaxCount += count;
                    }
                }
            }
            if (localMaxLen > maxLen) {
                maxLen = localMaxLen;
                maxCount = localMaxCount;
            } else if (localMaxLen == maxLen) {
                maxCount += localMaxCount;
            }
            dp.put(i, new int[]{localMaxLen, localMaxCount});
        }
        return maxCount;
    }
}
