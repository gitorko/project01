package com.demo.leetcode.medium._03_length3palindrome_1930;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1930. Unique Length-3 Palindromic Subsequences - MEDIUM](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)
 *
 * - set
 * - odd length palindrome
 *
 * https://www.youtube.com/watch?v=3THUt0vAFLU&ab_channel=NeetCode
 */
public class Length3PalindromeSubseq {

    @Test
    public void test() {
        Assertions.assertEquals(3, countPalindromicSubsequence("aabca"));
        Assertions.assertEquals(3, countPalindromicSubsequence2("aabca"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int countPalindromicSubsequence(String s) {
        Set<String> result = new HashSet<>();
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            right.put(c, right.get(c) - 1);
            if (right.get(c) == 0) {
                right.remove(c);
            }
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (left.contains(ch) && right.containsKey(ch)) {
                    result.add(c + "_" + ch);
                }
            }
            left.add(c);
        }
        return result.size();
    }

    /**
     * Time: O(n^2)
     * Space: O(26)
     */
    public int countPalindromicSubsequence2(String s) {
        int ans = 0;
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, s.length());

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        for (int i = 0; i < 26; i++)
            if (first[i] < last[i])
                ans += s.substring(first[i] + 1, last[i]).chars().distinct().count();

        return ans;
    }
}
