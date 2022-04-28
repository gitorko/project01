package com.demo.leetcode.easy._02_stringinstring_28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [28. Implement strStr - MEDIUM](https://leetcode.com/problems/implement-strstr/)
 *
 * - substring, window size
 * - SIMILAR_TO: [392. Is Subsequence - EASY](https://leetcode.com/problems/is-subsequence/)
 * - Knuth–Morris–Pratt algorithm
 *
 * https://www.youtube.com/watch?v=Gjkhm1gYIMw&ab_channel=NeetCode
 */
public class isSubarray {

    @Test
    public void test1() {
        Assertions.assertEquals(2, strStr("hello", "ll"));
        Assertions.assertEquals(2, strStr2("hello", "ll"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(12, strStr("ARCCDEFGHIARARCBF", "ARCB"));
        Assertions.assertEquals(12, strStr2("ARCCDEFGHIARARCBF", "ARCB"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(4, strStr("mississippi", "issip"));
        Assertions.assertEquals(4, strStr2("mississippi", "issip"));
    }

    /**
     * Without using substring
     * Time: O(m*n)
     * Space: O(1)
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0; i < l1 - l2 + 1; i++) {
            int count = 0;
            while (count < l2 && haystack.charAt(i + count) == needle.charAt(count))
                count++;
            if (count == l2)
                return i;
        }
        return -1;
    }

    /**
     * Time: O(m*n)
     * Space: O(1)
     */
    public int strStr2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
