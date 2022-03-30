package com.demo.leetcode.easy._13_searchinsertposition_35;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [35. Search Insert Position - EASY](https://leetcode.com/problems/search-insert-position/)
 *
 * - binary search
 *
 * https://www.youtube.com/watch?v=K-RYzDZkzCI&ab_channel=NeetCode
 */
public class SearchInsertPosition {
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        Assertions.assertEquals(2, searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
