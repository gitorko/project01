package com.demo.leetcode.easy._02_finddifferenceinstring_389;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [389. Find the Difference - EASY](https://leetcode.com/problems/find-the-difference/)
 *
 * - XOR
 * - char value of int and + and - leaves diff.
 */
public class FindDifferenceInString {

    @Test
    public void test() {
        Assertions.assertEquals('e', findTheDifference("abcd", "abcde"));
    }

    /**
     * Time: O(n)
     * Space: O(1) - no extra space.
     */
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) c ^= cs;
        for (char ct : t.toCharArray()) c ^= ct;
        return c;
    }
}
