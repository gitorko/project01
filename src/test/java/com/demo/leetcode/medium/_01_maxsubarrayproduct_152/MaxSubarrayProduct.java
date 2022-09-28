package com.demo.leetcode.medium._01_maxsubarrayproduct_152;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [152. Maximum Product Subarray - MEDIUM](https://leetcode.com/problems/maximum-product-subarray/)
 *
 * - max & min flip if negative
 * - only 2 variables to track, track both (max,min) for a pair.
 * - SIMILAR_TO: [53. Maximum Subarray - EASY](https://leetcode.com/problems/maximum-subarray/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=lXVy6YWFcRM&ab_channel=NeetCode
 */
public class MaxSubarrayProduct {

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        Assertions.assertEquals(6, maxProduct(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 3, 0, 0, 4, 5};
        Assertions.assertEquals(20, maxProduct(nums));
    }

    @Test
    public void test3() {
        int[] nums = {0, 0, 4, 5, 0, -5, -6};
        Assertions.assertEquals(30, maxProduct(nums));
    }

    /**
     * If we encounter negative element, we swap the max and min
     *
     * Case1 : All the elements are positive - Then answer is product of all the elements
     * Case2 : Array have positive and negative elements both :
     *  - If the number of negative elements is even multiplying all the negative numbers it will become positive.
     *  - If the number of negative elements is odd then you have to remove just one negative element.
     * Case3 : Array also contains 0 - array will be divided into subarray around that 0.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];
        //start from 2nd element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

}
