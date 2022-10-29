package com.demo.leetcode.easy._13_sqrt_69;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [69. Sqrtx - EASY](https://leetcode.com/problems/sqrtx/)
 *
 * - binary search
 * - always divide as multiply takes range out of bound.
 * - avoid division by zero.
 *
 * https://www.youtube.com/watch?v=zdMhGxRWutQ&ab_channel=NeetCodeIO
 */
public class SqrtNum {

    @Test
    public void test() {
        Assertions.assertEquals(2, mySqrt(7));
        Assertions.assertEquals(46339, mySqrt(2147395599));

    }

    /**
     * Time: O(log(n))
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
