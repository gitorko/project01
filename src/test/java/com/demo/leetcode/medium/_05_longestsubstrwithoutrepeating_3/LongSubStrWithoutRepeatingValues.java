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
 */
public class LongSubStrWithoutRepeatingValues {

    @Test
    public void test_getAllString() {
        Set<String> expected = Set.of("bca", "abc", "cab", "bce");
        Assertions.assertEquals(expected, getNonRepeatingSubstringValues("abcabcbbce"));
    }

    /**
     * Get the first max non repeating substring.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public Set<String> getNonRepeatingSubstringValues(String s) {

        int left = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int max = 0;
        int maxSoFar = 0;
        Set<Character> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if (max <= right - left + 1) {
                max = right - left + 1;
                //preserve index
                leftIndex = left;
                rightIndex = right;
            }

            if (max > maxSoFar) {
                //if maxSoFar is crossed then throw away current result and start fresh.
                maxSoFar = max;
                result = new HashSet<>();
                result.add(s.substring(leftIndex, rightIndex + 1));
            } else if (max == maxSoFar) {
                result.add(s.substring(leftIndex, rightIndex + 1));
            }
        }
        return result;
    }

}
