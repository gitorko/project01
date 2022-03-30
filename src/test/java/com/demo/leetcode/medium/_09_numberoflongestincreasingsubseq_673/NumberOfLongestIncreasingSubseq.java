package com.demo.leetcode.medium._09_numberoflongestincreasingsubseq_673;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [673. Number of Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
 *
 * - start from reverse, length + count dp
 * - SIMILAR_TO: [300. Longest Increasing Subsequence - MEDIUM](https://leetcode.com/problems/longest-increasing-subsequence/)
 *
 * PRACTICE
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
        int nums[] = {2,2,2,2,2};
        Assertions.assertEquals(5, findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        Map<Integer, int[]> dp = new HashMap<>();
        int result = 0;
        int lenLIS = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            //max will be the number itself so alway init to 1
            int maxLen = 1;
            int maxCount = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int length = dp.get(j)[0];
                    int count = dp.get(j)[1];
                    if (length + 1 > maxLen) {
                        maxLen = length + 1;
                        maxCount = count;
                    } else if (length + 1 == maxLen) {
                        maxCount += count;
                    }
                }
            }
            if (maxLen > lenLIS) {
                lenLIS = maxLen;
                result = maxCount;
            } else if (maxLen == lenLIS) {
                result += maxCount;
            }
            dp.put(i, new int[]{maxLen, maxCount});
        }
        return result;
    }
}
