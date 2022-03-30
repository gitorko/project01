package com.demo.leetcode.easy._02_verifyaliendict_953;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [953. Verifying an Alien Dictionary - EASY](https://leetcode.com/problems/verifying-an-alien-dictionary/)
 *
 * - compare adjacent words
 * - check length
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=OVgPAJIyX6o&ab_channel=NeetCode
 */
public class VerifyAlienDict {

    @Test
    public void test() {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Assertions.assertTrue(isAlienSorted(words, order));
    }

    @Test
    public void test2() {
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        Assertions.assertFalse(isAlienSorted(words, order));
    }

    @Test
    public void test3() {
        String[] words = {"word", "wordf", "zword"};
        String order = "zworldabcefghijkmnpqstuvxy";
        Assertions.assertFalse(isAlienSorted(words, order));
    }

    /**
     * Time: O(c) where c = total number of chars in all words
     * Space: O(1)
     */
    int[] mapping = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;

        //one less word as we compare pair
        for (int i = 0; i < words.length - 1; i++) {
            //compare neighbouring words
            if (bigger(words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    private boolean bigger(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n && i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
            }
        }
        //if first string is bigger than second then not in order.
        return n > m;
    }
}
