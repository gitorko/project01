package com.demo.leetcode.medium._05_longestsubstrwithoutrepeating_3;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [3. Longest Substring Without Repeating Characters - MEDIUM](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 *
 * - set + sliding window with left and right pointer
 * - If all strings are non repeating then max = max length of string.
 *
 * PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=wiGpQwVHdE0&ab_channel=NeetCode
 */
public class LongSubStrWithoutRepeating {

    @Test
    public void test() {
        String word = "abcabcbb";
        Assertions.assertEquals(3, lengthOfLongestSubstring(word));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
