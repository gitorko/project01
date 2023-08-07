package com.demo.leetcode.easy._03_containsduplicate2_219;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [219. Contains Duplicate II - EASY](https://leetcode.com/problems/contains-duplicate-ii)
 *
 * https://www.youtube.com/watch?v=ypn0aZ0nrL4&ab_channel=NeetCodeIO
 */
public class ContainsDuplicate2 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Assertions.assertTrue(containsNearbyDuplicate(nums, k));
    }

    /**
     * Time: O(n)
     * Space: O(k)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //after the first k elements need to delete just one element from numSet each time we move i + 1
            if (i > k) {
                numSet.remove(nums[i - k - 1]);
            }
            if (numSet.contains(nums[i])) {
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }
        return false;
    }
}
