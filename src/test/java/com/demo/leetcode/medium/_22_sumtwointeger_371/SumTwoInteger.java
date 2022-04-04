package com.demo.leetcode.medium._22_sumtwointeger_371;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [371. Sum of Two Integers - MEDIUM](https://leetcode.com/problems/sum-of-two-integers/)
 *
 * - xor, &
 *
 * https://www.youtube.com/watch?v=gVUrDV4tZfY&ab_channel=NeetCode
 */
public class SumTwoInteger {

    @Test
    public void test() {
        Assertions.assertEquals(20, getSum(16, 4));
    }

    /**
     * Time: O(32)
     * Space: O(1)
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
