package com.demo.leetcode.easy._01_plusone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [66. Plus One - EASY](https://leetcode.com/problems/plus-one/)
 *
 * - from reverse,early return
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=jIaA8boiG1s&ab_channel=NeetCode
 */
public class PlusOne {

    @Test
    public void test() {
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};
        Assertions.assertArrayEquals(expected, plusOne(digits));
    }

    @Test
    public void test2() {
        int[] digits = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};
        Assertions.assertArrayEquals(expected, plusOne(digits));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        //rest of numbers are 0, eg: 1000
        return ret;
    }
}
