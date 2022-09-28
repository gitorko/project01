package com.demo.leetcode.easy._02_stringinstring_28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [28. Implement strStr - MEDIUM](https://leetcode.com/problems/implement-strstr/)
 *
 * - substring, window size
 * - Knuth–Morris–Pratt algorithm can solve in O(m+n)
 * - SIMILAR_TO: [392. Is Subsequence - EASY](https://leetcode.com/problems/is-subsequence/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=Gjkhm1gYIMw&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=JoF0Z7nVSrA&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ&ab_channel=TusharRoy-CodingMadeSimple
 */
public class isSubarray {

    @Test
    public void test1() {
        Assertions.assertEquals(2, strStr("hello", "ll"));
        Assertions.assertEquals(2, strStr2("hello", "ll"));
        Assertions.assertEquals(2, strStr2("hello", "ll"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(12, strStr("ARCCDEFGHIARARCBF", "ARCB"));
        Assertions.assertEquals(12, strStr2("ARCCDEFGHIARARCBF", "ARCB"));
        Assertions.assertEquals(12, strStr3("ARCCDEFGHIARARCBF", "ARCB"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(4, strStr("mississippi", "issip"));
        Assertions.assertEquals(4, strStr2("mississippi", "issip"));
        Assertions.assertEquals(4, strStr3("mississippi", "issip"));
    }

    /**
     * Without using substring
     * Time: O(m*n)
     * Space: O(1)
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            int count = 0;
            while (count < n && haystack.charAt(i + count) == needle.charAt(count)) {
                count++;
            }
            if (count == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Uses substring function
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

    /**
     * KMP algorithm of needle matching.
     * HARD
     */
    public int strStr3(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int lps[] = computeLPS(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == pattern.length) {
                return i - pattern.length;
            }
        }
        return -1;
    }


    /**
     * Time: O(size of pattern)
     */
    private int[] computeLPS(char pattern[]) {
        int[] lps = new int[pattern.length];
        int previous = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[previous]) {
                lps[i] = previous + 1;
                previous++;
                i++;
            } else {
                if (previous != 0) {
                    previous = lps[previous - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
