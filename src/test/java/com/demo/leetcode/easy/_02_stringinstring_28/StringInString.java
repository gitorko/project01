package com.demo.leetcode.easy._02_stringinstring_28;

import org.junit.jupiter.api.Assertions;

/**
 * [28. Implement strStr - MEDIUM](https://leetcode.com/problems/implement-strstr/)
 *
 * - substring, window size
 *
 * https://www.youtube.com/watch?v=Gjkhm1gYIMw&ab_channel=NeetCode
 */
public class StringInString {

    public void test() {
        Assertions.assertEquals(2, strStr("hello", "ll"));
    }

    /**
     * Time: O(m*n)
     * Space: O(1)
     */
    public int strStr(String haystack, String needle) {
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
