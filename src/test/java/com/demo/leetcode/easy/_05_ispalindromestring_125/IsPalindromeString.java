package com.demo.leetcode.easy._05_ispalindromestring_125;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [125. Valid Palindrome - EASY](https://leetcode.com/problems/valid-palindrome/)
 *
 * - two pointer - no extra memory
 * - remember to do the check left < right in the inner loops as well.
 *
 * https://www.youtube.com/watch?v=jJXJ16kPFWg&ab_channel=NeetCode
 */
public class IsPalindromeString {

    @Test
    public void test() {
        Assertions.assertTrue(isPalindrome("racecar"));
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test_negative() {
        Assertions.assertFalse(isPalindrome("racecarc"));
        Assertions.assertFalse(isPalindrome("A man, a plan, is a canal: Panama"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
