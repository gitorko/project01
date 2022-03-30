package com.demo.leetcode.easy._02_palindromeadjacentswap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Minimum append to make string palindrome - EASY](https://www.geeksforgeeks.org/minimum-number-appends-needed-make-string-palindrome/)
 *
 * PRACTICE
 *
 * - Check how many min swap to end to make string palindrome.
 */
public class PalindromeMin {

    @Test
    public void test() {
        Assertions.assertEquals(2, palindromeMin("aabb"));
        Assertions.assertEquals(1, palindromeMin("raceca"));
        Assertions.assertEquals(2, palindromeMin("racec"));
        Assertions.assertEquals(1, palindromeMin("add"));
    }

    public int palindromeMin(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String check = s + sb.reverse();
            if (checkPalindrome(check)) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean checkPalindrome(String str) {
        return reverse(str).equals(str);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}
