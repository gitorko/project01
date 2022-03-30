package com.demo.leetcode.hard._02_rotatedarrayminfind2_154;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [154. Find Minimum in Rotated Sorted Array II - HARD](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)
 *
 * - nums may contain duplicates.
 */
public class FindMinRotatedSortedArray2 {

    @Test
    public void test() {
        int nums[] = {3, 4, 5, 1, 2, 2};
        Assertions.assertEquals(1, findMin(nums));
    }

    @Test
    public void test2() {
        int nums[] = {2, 2, 2, 0, 1};
        Assertions.assertEquals(0, findMin(nums));
    }

    /**
     * Time: O(log n)
     * Space: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == nums[right])
                right--;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
