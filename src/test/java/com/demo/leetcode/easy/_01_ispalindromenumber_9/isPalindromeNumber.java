package com.demo.leetcode.easy._01_ispalindromenumber_9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [9. Palindrome Number - EASY](https://leetcode.com/problems/palindrome-number/)
 *
 * - math, result * 10 + x % 10; without converting to string.
 * - SIMILAR_TO: [7. Reverse Integer - EASY](https://leetcode.com/problems/reverse-integer/)
 *
 * https://www.youtube.com/watch?v=yubRKwixN-U&ab_channel=NeetCode
 */
public class isPalindromeNumber {

    @Test
    public void test() {
        Assertions.assertTrue(isPalindromeNum(121));
        Assertions.assertTrue(isPalindromeNum(1331));
        Assertions.assertFalse(isPalindromeNum(-121));
        Assertions.assertFalse(isPalindromeNum(123));
    }

    public boolean isPalindromeNum(int x) {
        //negative numbers are invalid.
        //if the remainder is 0 then both sides cant be equal. eg: 120/10 = 0
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int result = 0;
        //only process half the numbers
        while (x > result) {
            //mod gets the right side digit
            result = result * 10 + x % 10;
            //divide removes the right side digit
            x = x / 10;
        }
        //in even case both will be equal
        //in odd case except for mid it will be equal.
        return (x == result || x == result / 10);
    }
}
