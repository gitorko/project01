package com.demo.leetcode.medium._05_longestsubstrwithoutrepeating_3;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [3. Longest Substring Without Repeating Characters - MEDIUM](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 *
 * - sliding window
 * - SIMILAR_TO: [340. Longest Substring with At Most K Distinct Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=wiGpQwVHdE0&ab_channel=NeetCode
 */
public class LongSubStrWithoutRepeating {

    @Test
    public void test1() {
        String word = "abcabcbb";
        Assertions.assertEquals(3, lengthOfLongestSubstring(word));
    }

    @Test
    public void test2() {
        String word = "bbbbb";
        Assertions.assertEquals(1, lengthOfLongestSubstring(word));
    }

    @Test
    public void test3() {
        String word = "pwwkew";
        Assertions.assertEquals(3, lengthOfLongestSubstring(word));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        //left and right pointer
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            while (charSet.contains(rightChar)) {
                char leftChar = s.charAt(left);
                charSet.remove(leftChar);
                left++;
            }
            charSet.add(rightChar);
            int window = right - left + 1;
            max = Math.max(max, window);
            right++;
        }
        return max;
    }

}
