package com.demo.leetcode.medium._05_permutation2string_567;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [567. Permutation in String - MEDIUM](https://leetcode.com/problems/permutation-in-string/)
 *
 * - Sliding window, two hashmap.
 * - avoiding checking 2 maps each time, maintaining a single matches counter.
 * - SIMILAR_TO: [438. Find All Anagrams in a String - MEDIUM](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 *
 * https://www.youtube.com/watch?v=UbyhOgBN834&ab_channel=NeetCode
 */
public class PermutationIn2String {
    @Test
    public void test1() {
        Assertions.assertTrue(checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    @Test
    public void test3() {
        Assertions.assertTrue(checkInclusion("a", "ab"));
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
        if (matches == 26) {
            return true;
        }

        //since first window already initialized above we start from next window size
        int left = 0;
        int right = s1.length();
        while (right < s2.length()) {
            //Add the new char to right side
            int rIndex = s2.charAt(right) - 'a';
            s2map[rIndex]++;
            if (s2map[rIndex] == s1map[rIndex]) {
                matches++;
            } else if (s2map[rIndex] - 1 == s1map[rIndex]) {
                matches--;
            }

            //Remove char from left side
            int lIndex = s2.charAt(left) - 'a';
            s2map[lIndex]--;
            if (s2map[lIndex] == s1map[lIndex]) {
                matches++;
            } else if (s2map[lIndex] + 1 == s1map[lIndex]) {
                matches--;
            }
            left++;
            right++;
            if (matches == 26)  {
                return true;
            }
        }
        return matches == 26;
    }

}
