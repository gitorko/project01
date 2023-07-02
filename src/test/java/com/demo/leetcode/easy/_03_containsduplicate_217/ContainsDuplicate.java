package com.demo.leetcode.easy._03_containsduplicate_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [217. Contains Duplicate - EASY](https://leetcode.com/problems/contains-duplicate/)
 *
 * - sort & compare neighbours
 * - hashset to get unique values in array
 *
 * https://www.youtube.com/watch?v=3OamzN90kPg&ab_channel=NeetCode
 */
public class ContainsDuplicate {

    @Test
    public void test() {
        int nums[] = {1, 2, 3, 1};
        Assertions.assertTrue(containsDuplicate(nums));
        Assertions.assertTrue(containsDuplicate2(nums));
    }

    /**
     * Use set - extra memory
     *
     * Instead of number if string is given, str.toCharArray();
     * if chars are only 26 use array table and space become O(1)
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    /**
     * Sorting and comparing neighbours.
     *
     * Time: O(n*log(n))
     * Space: O(1)
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
