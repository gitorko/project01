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
        //iterate over nums and assign to numSet.
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //check if previous number doesnt exist, indicates it the beginning of numSet
            if (!numSet.contains(nums[i] - 1)) {
                int j = 0;
                while (numSet.contains(nums[i] + j)) {
                    j++;
                }
                result = Math.max(result, j);
            }
        }
        return result;
    }
}
