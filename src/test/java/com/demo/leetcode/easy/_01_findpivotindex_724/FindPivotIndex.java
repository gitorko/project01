package com.demo.leetcode.easy._01_findpivotindex_724;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [724. Find Pivot Index - EASY](https://leetcode.com/problems/find-pivot-index/)
 *
 * - total sum of array.
 * - prefix == sum - prefix - nums[i]
 *
 * https://www.youtube.com/watch?v=u89i60lYx8U&ab_channel=NeetCode
 */
public class FindPivotIndex {

    @Test
    public void test() {
        int nums[] = {1, 7, 3, 6, 5, 6};
        Assertions.assertEquals(3, pivotIndex(nums));
    }

    /**
     * Time: O(n)
     */
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == sum - prefix - nums[i])
                return i;
            prefix += nums[i];
        }
        return -1;
    }
}
