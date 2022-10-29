package com.demo.leetcode.easy._02_reversestring_344;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [344. Reverse String - EASY](https://leetcode.com/problems/reverse-string/)
 *
 * - two pointer
 * - PRACTICE: P4
 *
 * https://www.youtube.com/watch?v=_d0T_2Lk2qA&ab_channel=NeetCode
 */
public class ReverseString {

    @Test
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};
        reverseString(s);
        Assertions.assertArrayEquals(expected, s);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
