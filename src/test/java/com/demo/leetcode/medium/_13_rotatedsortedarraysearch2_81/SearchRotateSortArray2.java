package com.demo.leetcode.medium._13_rotatedsortedarraysearch2_81;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [81. Search in Rotated Sorted Array II - MEDIUM](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
 *
 * - binary search
 * - SIMILAR_TO: [33. Search in Rotated Sorted Array - MEDIUM](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 *
 * https://www.youtube.com/watch?v=oUnF7o88_Xc&ab_channel=NeetCodeIO
 */
public class SearchRotateSortArray2 {

    @Test
    public void test() {
        int nums[] = {2, 5, 6, 0, 0, 1, 2}, target = 0;
        Assertions.assertTrue(search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // nums[mid..n - 1] are sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
