package com.demo.leetcode.easy._05_countbinarysubstring_696;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [696. Count Binary Substrings - EASY](https://leetcode.com/problems/count-binary-substrings/)
 *
 * - two pointer, curr, prev
 * - PRACTICE: P1
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
        int prevCount = 0;
        int currCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                result += Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
            } else {
                currCount++;
            }
        }
        result += Math.min(prevCount, currCount);
        return result;
    }
}
