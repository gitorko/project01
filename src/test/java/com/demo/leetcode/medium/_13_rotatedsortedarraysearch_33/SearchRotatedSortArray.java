package com.demo.leetcode.medium._13_rotatedsortedarraysearch_33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [33. Search in Rotated Sorted Array - MEDIUM](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 *
 * - binary search, left portion, right portion
 * - SIMILAR_TO: [81. Search in Rotated Sorted Array II - MEDIUM](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=U8XENwh8Oy8&ab_channel=NeetCode
 */
public class SearchRotatedSortArray {

    @Test
    public void test() {
        int nums[] = {4, 5, 6, 7, 0, 1, 2}, target = 0;
        Assertions.assertEquals(4, search(nums, target));
    }

    /**
     * Time: O(log n)
     * Space: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                //You are inside right portion
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
