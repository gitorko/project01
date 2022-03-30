package com.demo.leetcode.medium._01_removeduplicatessortedarray_80;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [80. Remove Duplicates from Sorted Array II - MEDIUM](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
 *
 * - num > nums[i - 2]
 *
 * PRACTICE
 */
public class RemoveDuplicates {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Assertions.assertEquals(5, removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;
        return i;
    }
}
