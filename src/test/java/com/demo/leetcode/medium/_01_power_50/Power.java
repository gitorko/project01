package com.demo.leetcode.medium._01_power_50;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [50. Pow(x, n) - MEDIUM](https://leetcode.com/problems/powx-n/)
 *
 * - recursion n/2
 * - math
 *
 * https://www.youtube.com/watch?v=g9YQyYi4IQQ&ab_channel=NeetCode
 */
public class Power {

    @Test
    public void test() {
        Assertions.assertEquals(1024.00000, myPow(2.00000, 10));
        Assertions.assertEquals(9.261000000000001, myPow(2.10000, 3));
        Assertions.assertEquals(0.25000, myPow(2.00000, -2));
        Assertions.assertEquals(4, myPow(2, 2));
        Assertions.assertEquals(8, myPow(2, 3));
    }

    /**
     * Time: O(logn)
     * Space: O(1)
     */
    public double myPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        //for odd number make n as even.
        if (n % 2 == 1)
            return x * myPow(x, n - 1);
        //for even number reduce the recursion call.
        return myPow(x * x, n / 2);
    }
}
