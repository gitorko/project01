package com.demo.leetcode.medium._03_longestconsecutivesequence_128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [128. Longest Consecutive Sequence - MEDIUM](https://leetcode.com/problems/longest-consecutive-sequence/)
 *
 * - Set, check previous, number line
 * - SIMILAR_TO: [674. Longest Continuous Increasing Subsequence - EASY](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)
 * - PRACTICE: P3
 * - MISTAKES: Will probably miss checking if beginning of sequence and loop over all, causing timeout exception
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
        for (int num : nums) {
            //check if previous number doesn't exist, indicates it the beginning of numSet, without this check there will be timeout
            if (!numSet.contains(num - 1)) {
                int tempResult = 0;
                while (numSet.contains(num)) {
                    tempResult++;
                    num++;
                }
                result = Math.max(tempResult, result);
            }

        }
        return result;
    }
}
