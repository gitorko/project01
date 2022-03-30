package com.demo.leetcode.easy._05_countbinarysubstring_696;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [696. Count Binary Substrings - EASY](https://leetcode.com/problems/count-binary-substrings/)
 *
 * - two pointer, curr, prev
 *
 * https://www.youtube.com/watch?v=MGPHPadxhtQ&ab_channel=AlgorithmsMadeEasy
 */
public class BinarySubstring {

    @Test
    public void test() {
        Assertions.assertEquals(6, countBinarySubstrings("00110011"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int countBinarySubstrings(String s) {
        int result = 0;
        int prev = 0;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else {
                curr++;
            }
        }
        result += Math.min(prev, curr);
        return result;
    }
}
