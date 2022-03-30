package com.demo.leetcode.easy._01_summaryrange_228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [228. Summary Ranges - EASY](https://leetcode.com/problems/summary-ranges/)
 *
 * - two loops
 *
 * PRACTICE
 */
public class SummaryRange {

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = Arrays.asList("0->2", "4->5", "7");
        Assertions.assertEquals(expected, summaryRanges(nums));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int begin = nums[i];
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1)
                i++;
            int end = nums[i];
            if (begin == end)
                result.add("" + begin);
            else
                result.add("" + begin + "->" + end);
        }
        return result;
    }
}
