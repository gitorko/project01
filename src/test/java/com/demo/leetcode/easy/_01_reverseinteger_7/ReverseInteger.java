package com.demo.leetcode.easy._01_reverseinteger_7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [7. Reverse Integer - EASY](https://leetcode.com/problems/reverse-integer/)
 *
 * - mod by 10, divide by 10
 * - SIMILAR_TO: [9. Palindrome Number - EASY](https://leetcode.com/problems/palindrome-number/)
 */
public class ReverseInteger {

    @Test
    public void test() {
        Assertions.assertEquals(321, reverse(123));
        Assertions.assertEquals(-321, reverse(-123));
        Assertions.assertEquals(21, reverse(120));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            if (result > Integer.MAX_VALUE) return 0;
            if (result < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }
        return (int) result;
    }
}
