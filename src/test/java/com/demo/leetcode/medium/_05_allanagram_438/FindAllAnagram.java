package com.demo.leetcode.medium._05_allanagram_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [438. Find All Anagrams in a String - MEDIUM](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 *
 * - two pointer
 * - SIMILAR_TO: [567. Permutation in String - MEDIUM](https://leetcode.com/problems/permutation-in-string/)
 *
 * https://www.youtube.com/watch?v=G8xtZy0fDKg&ab_channel=NeetCode
 */
public class FindAllAnagram {

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(0, 6);
        Assertions.assertEquals(expected, findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(2);
        Assertions.assertEquals(expected, findAnagrams("bpaa", "aa"));
    }

    @Test
    public void test3() {
        List<Integer> expected = Arrays.asList(0, 3);
        Assertions.assertEquals(expected, findAnagrams("abpab", "ab"));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(Collections.emptyList(), findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    /**
     * Time: O(n)
     * Space: O(26)
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] == sCount[i]) {
                matches++;
            }
        }
        if (matches == 26) {
            result.add(0);
        }

        int left = 0;
        int right = p.length();
        while (right < s.length()) {
            //Add the new char to right side
            int rIndex = s.charAt(right) - 'a';
            sCount[rIndex]++;
            if (sCount[rIndex] == pCount[rIndex]) {
                matches++;
            } else if (sCount[rIndex] - 1 == pCount[rIndex]) {
                matches--;
            }

            //Remove char from left side
            int lIndex = s.charAt(left) - 'a';
            sCount[lIndex]--;
            if (sCount[lIndex] == pCount[lIndex]) {
                matches++;
            } else if (sCount[lIndex] + 1 == pCount[lIndex]) {
                matches--;
            }
            left++;
            right++;
            if (matches == 26) {
                result.add(left);
            }
        }
        return result;
    }
}
