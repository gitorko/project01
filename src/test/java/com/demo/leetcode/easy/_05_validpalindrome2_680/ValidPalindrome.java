package com.demo.leetcode.easy._05_validpalindrome2_680;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [680. Valid Palindrome II - EASY](https://leetcode.com/problems/valid-palindrome-ii/)
 *
 * - two pointer
 */
public class ValidPalindrome {

    @Test
    public void test() {
        Assertions.assertTrue(validPalindrome("aba"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            //no need check if both are same char
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean validPalindrome(final String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
