package com.demo.leetcode.medium._03_longestconsecutivesequence_128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [128. Longest Consecutive Sequence - MEDIUM](https://leetcode.com/problems/longest-consecutive-sequence/)
 *
 * - set, check previous, number line
 * - SIMILAR_TO: [674. Longest Continuous Increasing Subsequence - EASY](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)
 *
 * PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=P6RZZMu_maU&ab_channel=NeetCode
 */
public class LongConsecutiveSequence {

    @Test
    public void test() {
        int nums[] = {100, 4, 200, 1, 3, 2};
        Assertions.assertEquals(4, longestConsecutive(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int longestConsecutive(int[] nums) {
        //iterate over nums and assign to set.
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            //check if previous number doesnt exist, indicates it the beginning of set
            if (!set.contains(nums[i] - 1)) {
                int length = 0;
                while (set.contains(nums[i] + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
