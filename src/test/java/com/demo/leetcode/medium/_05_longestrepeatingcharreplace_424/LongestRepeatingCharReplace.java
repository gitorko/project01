package com.demo.leetcode.medium._05_longestrepeatingcharreplace_424;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [424. Longest Repeating Character Replacement - MEDIUM](https://leetcode.com/problems/longest-repeating-character-replacement/)
 *
 * - set + sliding, window-maxCount>k
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=gqXU1UyA8pk&ab_channel=NeetCode
 */
public class LongestRepeatingCharReplace {

    @Test
    public void test() {
        Assertions.assertEquals(4, characterReplacement("ABAB", 2));
    }

    /**
     * Time: O(n)
     * Space: O(128)=O(1)
     */
    public int characterReplacement(String s, int k) {
        int result = 0;
        int maxCount = 0;
        int[] frequency = new int[128];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            frequency[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, frequency[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxCount > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
