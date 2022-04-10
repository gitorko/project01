package com.demo.leetcode.medium._05_longestpalindromesubstr_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [5. Longest Palindromic Substring - MEDIUM](https://leetcode.com/problems/longest-palindromic-substring/)
 *
 * - expand around center, two pointer
 * - odd and even case
 * - manacher algorithm
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=XYQecbcd6_c&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=V-sEwsca1ak - Manacher Algorithm O(N) time. Difficult to code during interview.
 */
public class LongestPalindromeSubstr {

    @Test
    public void test() {
        Assertions.assertEquals("aba", longestPalindrome("babad"));
        Assertions.assertEquals("bb", longestPalindrome("cbbd"));
        Assertions.assertEquals("b", longestPalindrome("b"));
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1);

            String largest = odd.length() > even.length() ? odd : even;
            ans = ans.length() > largest.length() ? ans : largest;
        }

        return ans;
    }

    private String expandAroundCenter(String s, int left, int right) {
        if (s == null || left > right) {
            return "";
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left = left < 0 ? 0 : left + 1;
        right = right > s.length() ? s.length() : right;

        return s.substring(left, right);
    }

}
