package com.demo.leetcode.easy._05_removeduplicatesortedarray_26;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [26. Remove Duplicates from Sorted Array - EASY](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 *
 * - two pointer - modifying the input array in-place with O(1)
 * - copy to left
 * - SIMILAR_TO: [27. Remove Element - EASY](https://leetcode.com/problems/remove-element/)
 *
 * https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
 */
public class RemoveDuplicateSortedArray {

    @Test
    public void test() {
        int nums[] = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assertions.assertEquals(5, removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = 1;
        //start from 2nd element
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        //reset values left..nums.length
        Arrays.fill(nums, left, nums.length, 0);
        return left;
    }
}
