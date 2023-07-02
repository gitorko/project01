package com.demo.leetcode.easy._01_uglynumber_263;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [263. Ugly Number - EASY](https://leetcode.com/problems/ugly-number/)
 *
 * - keep dividing till 1.
 *
 * https://www.youtube.com/watch?v=M0Zay1Qr9ws&ab_channel=NeetCode
 */
public class UglyNumber {

    @Test
    public void test() {
        Assertions.assertTrue(isUgly(6));
        Assertions.assertTrue(isUgly(1));
        Assertions.assertFalse(isUgly(14));
    }

    /**
     * Time: O(log(n))
     */
    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }

}
