package com.demo.leetcode.medium._05_longestpalindromesubstr_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [5. Longest Palindromic Substring - MEDIUM](https://leetcode.com/problems/longest-palindromic-substring/)
 *
 * - expand around center, two pointer
 * - odd and even case
 * - manacher algorithm
 * - SIMILAR_TO: [647. Palindromic Substrings - MEDIUM](https://leetcode.com/problems/palindromic-substrings/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=XYQecbcd6_c&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=V-sEwsca1ak - Manacher Algorithm O(N) time. Difficult to code during interview.
 */
public class LongestPalindromeSubstr {

    @Test
    public void test1() {
        Assertions.assertEquals("bab", longestPalindrome("babad"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("bb", longestPalindrome("cbbd"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals("b", longestPalindrome("b"));
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public String longestPalindrome(String s) {
        //edge case
        if (s == null || s.length() <= 1)
            return s;

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = expandAroundCenter(s, i, i);
            if (odd.length() > result.length()) {
                result = odd;
            }
            String even = expandAroundCenter(s, i, i + 1);
            if (even.length() > result.length()) {
                result = even;
            }
        }
        return result;
    }

    private String expandAroundCenter(String s, int left, int right) {
        String result = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result = s.substring(left, right + 1);
            left--;
            right++;
        }
        return result;
    }

}
