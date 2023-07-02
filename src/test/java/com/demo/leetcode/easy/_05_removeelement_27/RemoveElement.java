package com.demo.leetcode.easy._05_removeelement_27;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [27. Remove Element - EASY](https://leetcode.com/problems/remove-element/)
 *
 * - two pointer, copy to left
 * - SIMILAR_TO: [26. Remove Duplicates from Sorted Array - EASY](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 *
 * https://www.youtube.com/watch?v=Pcd1ii9P9ZI&ab_channel=NeetCode
 */
public class RemoveElement {

    @Test
    public void test() {
        int nums[] = {1, 5, 2, 5, 3, 5};
        Assertions.assertEquals(3, removeElement(nums, 5));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        Arrays.fill(nums, left, nums.length, 0);
        return left;
    }
}
