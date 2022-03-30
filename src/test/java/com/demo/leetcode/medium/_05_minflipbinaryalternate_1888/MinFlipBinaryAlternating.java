package com.demo.leetcode.medium._05_minflipbinaryalternate_1888;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1888. Minimum Number of Flips to Make the Binary String Alternating - MEDIUM](https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/)
 *
 * - sliding window
 *
 * https://www.youtube.com/watch?v=MOeuK6gaC2A&ab_channel=NeetCode
 */
public class MinFlipBinaryAlternating {

    @Test
    public void test() {
        Assertions.assertEquals(2, minFlips("111000"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        char[] alt1 = new char[s.length()];
        char[] alt2 = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                alt1[i] = '0';
                alt2[i] = '1';
            } else {
                alt1[i] = '1';
                alt2[i] = '0';
            }
        }
        int result = s.length();
        int diff1 = 0;
        int diff2 = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) != alt1[right]) diff1++;
            if (s.charAt(right) != alt2[right]) diff2++;

            if (right - left + 1 > n) {
                if (s.charAt(left) != alt1[left]) diff1--;
                if (s.charAt(left) != alt2[left]) diff2--;
                left++;
            }

            if (right - left + 1 == n) {
                result = Math.min(Math.min(result, diff1), diff2);
            }
        }
        return result;
    }
}
