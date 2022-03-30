package com.demo.leetcode.medium._05_permutation2string_567;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [567. Permutation in String - MEDIUM](https://leetcode.com/problems/permutation-in-string/)
 *
 * - matches
 * - Sliding window, two hashmap.
 * - avoiding checking 2 maps each time, maintaining a single matches counter.
 * - compare hashmap each time making it O(n) instead of O(26*n) if we
 *
 * https://www.youtube.com/watch?v=UbyhOgBN834&ab_channel=NeetCode
 */
public class PermutationIn2String {
    @Test
    public void test() {
        Assertions.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assertions.assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        //edge case
        if (s1.length() > s2.length())
            return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        //first window initialized
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i]) matches++;
        }

        //since first window already initialized above we start from next window size
        int start = s1.length();
        int end = s2.length();
        int left = 0;
        for (int right = start; right < end; right++, left++) {
            if (matches == 26) return true;

            //Add the new char
            int index = s2.charAt(right) - 'a';
            s2map[index]++;
            if (s1map[index] == s2map[index]) {
                matches++;
            } else if (s1map[index] + 1 == s2map[index]) {
                matches--;
            }

            //Remove left side char
            index = s2.charAt(left) - 'a';
            s2map[index]--;
            if (s1map[index] == s2map[index]) {
                matches++;
            } else if (s1map[index] - 1 == s2map[index]) {
                matches--;
            }
        }
        return matches == 26;
    }

}
