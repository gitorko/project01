package com.demo.leetcode.medium._03_length3palindrome_1930;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1930. Unique Length 3 Palindromic Subsequences - MEDIUM](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)
 *
 * - set + map
 * - odd length palindrome
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=3THUt0vAFLU&ab_channel=NeetCode
 */
public class Length3PalindromeSubseq {

    @Test
    public void test1() {
        Assertions.assertEquals(3, countPalindromicSubsequence("aabca"));
        Assertions.assertEquals(3, countPalindromicSubsequence2("aabca"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(4, countPalindromicSubsequence("bbcbaba"));
        Assertions.assertEquals(4, countPalindromicSubsequence2("bbcbaba"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int countPalindromicSubsequence(String s) {
        Set<String> result = new HashSet<>();
        Map<Character, Integer> left = new HashMap();
        Map<Character, Integer> right = new HashMap();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            //remove from right
            right.put(c, right.get(c) - 1);
            //26 times loop
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (left.containsKey(ch) && left.get(ch) > 0 && right.containsKey(ch) && right.get(ch) > 0) {
                    result.add(ch + "_" + c + "_" + ch);
                }
            }
            //add to left
            left.put(c, left.getOrDefault(c, 0) + 1);
        }
        return result.size();
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * Track the first and last occurrence of each character.
     * For each character count unique characters between its first and last occurrence.
     */
    public int countPalindromicSubsequence2(String s) {
        int result = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                result += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }
        }
        return result;
    }
}
