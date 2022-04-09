package com.demo.leetcode.easy._02_anagram_242;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [242. Valid Anagram - EASY](https://leetcode.com/problems/valid-anagram/)
 *
 * - check length first.
 * - use map, single pass.
 *
 * https://www.youtube.com/watch?v=9UtInBqnCgA&ab_channel=NeetCode
 */
public class CheckAnagram {

    @Test
    public void test() {
        Assertions.assertTrue(isAnagram("anagram", "nagaram"));
        Assertions.assertFalse(isAnagram("rat", "car"));
    }

    /**
     * Time: O(n),
     * Space: O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countMap = new int[26];
        //iterate first string, add to set
        for (int i = 0; i < s.length(); i++) {
            countMap[s.charAt(i) - 'a']++;
        }
        //iterate 2nd string and reduce count, if negative
        for (int i = 0; i < t.length(); i++) {
            countMap[t.charAt(i) - 'a']--;
            if (countMap[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
