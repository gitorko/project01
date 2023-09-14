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
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=P6RZZMu_maU&ab_channel=NeetCode
 */
public class LongConsecutiveSequence {

    @Test
    public void test1() {
        int nums[] = {100, 4, 200, 1, 3, 2};
        Assertions.assertEquals(4, longestConsecutive(nums));
        Assertions.assertEquals(4, longestConsecutive2(nums));
    }

    @Test
    public void test2() {
        int nums[] = {1, 2, 0, 1};
        Assertions.assertEquals(3, longestConsecutive(nums));
        Assertions.assertEquals(3, longestConsecutive2(nums));
    }

    @Test
    public void test3() {
        int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Assertions.assertEquals(9, longestConsecutive(nums));
        Assertions.assertEquals(9, longestConsecutive2(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int longestConsecutive(int[] nums) {
        //iterate over nums and assign to set.
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCount = 0;
        for (int num : nums) {
            //check if previous number doesn't exist, indicates it the beginning of numSet
            //without this check there will be timeout as search space becomes big
            if (!numSet.contains(num - 1)) {
                int count = 0;
                while (numSet.contains(num)) {
                    count++;
                    num++;
                }
                maxCount = Math.max(count, maxCount);
            }

        }
        return maxCount;
    }

    /**
     * sorting
     * Time: O(n*log(n))
     * Space: O(1)
     */
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        //start from first number
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                //do nothing
            } else if (nums[i] - 1 == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
