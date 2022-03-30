package com.demo.leetcode.medium._01_productofarrayexceptself_238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [238. Product of Array Except Self - MEDIUM](https://leetcode.com/problems/product-of-array-except-self/)
 *
 * - option1: multiply all and divide by the number.
 * - option2: prefix + postfix
 *
 * https://www.youtube.com/watch?v=bNvIQI2wAjk&ab_channel=NeetCode
 */
public class ProductOfArray {

    @Test
    public void test() {
        int nums[] = {1, 2, 3, 4};
        int expected[] = {24, 12, 8, 6};
        Assertions.assertArrayEquals(productExceptSelf(nums), expected);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }
        return res;
    }
}
