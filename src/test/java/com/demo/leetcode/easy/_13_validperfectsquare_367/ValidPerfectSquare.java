package com.demo.leetcode.easy._13_validperfectsquare_367;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [367. Valid Perfect Square - EASY](https://leetcode.com/problems/valid-perfect-square/)
 *
 * - binary search, Cant use Math.sqrt
 * - handle overflow on mid * mid
 *
 * https://www.youtube.com/watch?v=Cg_wWPHJ2Sk&ab_channel=NeetCode
 */
public class ValidPerfectSquare {

    @Test
    public void test1() {
        Assertions.assertTrue(isPerfectSquare(1));
    }

    @Test
    public void test2() {
        Assertions.assertTrue(isPerfectSquare(16));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isPerfectSquare(14));
    }

    /**
     * Time: O(log(n))
     */
    public boolean isPerfectSquare(int num) {
        long left = 1l;
        long right = num;
        //use = to cover edge case when only one number
        while (left < right) {
            //use long to avoid overflow
            long mid = (left + right) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num;
    }

}
