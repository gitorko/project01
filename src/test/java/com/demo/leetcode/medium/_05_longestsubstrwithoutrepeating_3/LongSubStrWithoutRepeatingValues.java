package com.demo.leetcode.medium._05_longestsubstrwithoutrepeating_3;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [3. Longest Substring Without Repeating Characters - MEDIUM](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 *
 * - instead of count return string.
 * - set + sliding Window with left and right pointer
 * - PRACTICE: P3
 */
public class LongSubStrWithoutRepeatingValues {

    @Test
    public void test1() {
        Set<String> expected = Set.of("bca", "abc", "cab", "bce");
        Assertions.assertEquals(expected, getNonRepeatingSubstringValues("abcabcbbce"));
    }

    @Test
    public void test2() {
        Set<String> expected = Set.of("abcde");
        Assertions.assertEquals(expected, getNonRepeatingSubstringValues("abcdedaecdd"));
    }

    /**
     * Get the first max non repeating substring.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public Set<String> getNonRepeatingSubstringValues(String s) {

        Set<Character> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        //left and right pointer
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            while (set.contains(rightChar)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }
            set.add(rightChar);
            right++;
            int window = right - left;
            if (max == window) {
                result.add(s.substring(left, right));
            } else if (max < window) {
                max = window;
                result = new HashSet<>();
                result.add(s.substring(left, right));
            }
        }
        return result;
    }

}
