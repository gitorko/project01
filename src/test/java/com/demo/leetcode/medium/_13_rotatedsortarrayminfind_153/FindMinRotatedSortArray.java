package com.demo.leetcode.medium._13_rotatedsortarrayminfind_153;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [153. Find Minimum in Rotated Sorted Array - MEDIUM](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 *
 * - binary search
 * - SIMILAR_TO: [154. Find Minimum in Rotated Sorted Array II - HARD](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=nIVW4P8b1VA&ab_channel=NeetCode
 */
public class FindMinRotatedSortArray {

    @Test
    public void test1() {
        int nums[] = {3, 4, 5, 1, 2};
        Assertions.assertEquals(1, findMin(nums));
    }

    @Test
    public void test2() {
        int nums[] = {2, 1};
        Assertions.assertEquals(1, findMin(nums));
    }

    @Test
    public void test3() {
        int nums[] = {3, 1, 2};
        Assertions.assertEquals(1, findMin(nums));
    }

    /**
     * Time: O(log n)
     * Space: O(1)
     *
     *  Check the middle element, if it is less than previous one, then it is minimum.
     *  If not, there are 2 conditions as well:
     *    1. If it is greater than left search right,
     *    2. If it is less than left search left
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
