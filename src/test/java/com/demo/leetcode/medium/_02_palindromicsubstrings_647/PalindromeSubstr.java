package com.demo.leetcode.medium._02_palindromicsubstrings_647;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [647. Palindromic Substrings - MEDIUM](https://leetcode.com/problems/palindromic-substrings/)
 *
 * - expand around center, odd even
 * - SIMILAR_TO: [5. Longest Palindromic Substring - MEDIUM](https://leetcode.com/problems/longest-palindromic-substring/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=4RACzI5-du8&ab_channel=NeetCode
 */
public class PalindromeSubstr {

    @Test
    public void test() {
        Assertions.assertEquals(3, countSubstrings("abc"));
        Assertions.assertEquals(6, countSubstrings("aaa"));
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    int count = 0;

    public int countSubstrings(String s) {
        count = 0;
        //edge case
        if (s == null || s.length() == 0)
            return 0;

        for (int i = 0; i < s.length(); i++) {
            //odd length
            expandAroundCenter(s, i, i);
            //even length
            expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
