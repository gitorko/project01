package com.demo.leetcode.medium._10_duplicatenumber_287;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [287. Find the Duplicate Number - MEDIUM](https://leetcode.com/problems/find-the-duplicate-number/)
 *
 * - floyd cycle
 * - cyclic sort
 *
 * https://www.youtube.com/watch?v=wjYnzkAhcNk&ab_channel=NeetCode
 */
public class DuplicateNumber {

    @Test
    public void test1() {
        int[] nums = {1, 3, 4, 2, 2};
        Assertions.assertEquals(2, findDuplicate(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 2, 2, 2};
        Assertions.assertEquals(2, findDuplicate(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) break;
        }
        return slow;
    }
}
