package com.demo.leetcode.medium._21_findallduplicates_442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [442. Find All Duplicates in an Array - MEDIUM](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
 *
 * - cyclic sort
 */
public class FindAllDuplicatesArray {

    @Test
    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = Arrays.asList(2, 3);
        Assertions.assertEquals(expected, findDuplicates(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            nums[Math.abs(num) - 1] *= -1;
            if (nums[Math.abs(num) - 1] > 0)
                result.add(Math.abs(num));
        }
        return result;
    }
}
