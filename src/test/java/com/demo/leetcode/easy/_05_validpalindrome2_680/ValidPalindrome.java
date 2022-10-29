package com.demo.leetcode.easy._05_validpalindrome2_680;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [680. Valid Palindrome II - EASY](https://leetcode.com/problems/valid-palindrome-ii/)
 *
 * - two pointer
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=JrxRYBwG6EI&ab_channel=NeetCode
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
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
