package com.demo.leetcode.medium._02_longestsubstringkrepeating_395;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [395. Longest Substring with At Least K Repeating Characters - MEDIUM](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
 *
 * - recursion
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=5QpMpO2CAb0&ab_channel=AlgorithmsMadeEasy
 */
public class LargestSubstringKRepeat {

    @Test
    public void test() {
        Assertions.assertEquals(3, longestSubstring("aaabb", 3));
        Assertions.assertEquals(3, longestSubstring("aaabb", 3));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    private int helper(char[] ch, int start, int end, int k) {
        //substring length shorter than k.
        if (end - start < k) return 0;

        //create frequency
        int[] frequency = new int[26];
        for (int i = start; i < end; i++) {
            frequency[ch[i] - 'a']++;
        }

        for (int j = start; j < end; j++) {
            if (frequency[ch[j] - 'a'] < k) {
                int left = helper(ch, start, j, k);
                int right = helper(ch, j + 1, end, k);
                return Math.max(left, right);
            }
        }
        return end - start;
    }

    /**
     * Time: O(n)
     * Space: O(26)
     */
    public int longestSubstring2(String s, int k) {
        int ans = 0;

        for (int n = 1; n <= 26; ++n)
            ans = Math.max(ans, longestSubstringWithNUniqueCharacters(s, k, n));

        return ans;
    }

    private int longestSubstringWithNUniqueCharacters(final String s, int k, int n) {
        int result = 0;
        int uniqueChars = 0; // unique chars in current substring s[l..r]
        int noLessThanK = 0; // # of chars >= k
        int[] count = new int[128];

        for (int l = 0, r = 0; r < s.length(); r++) {
            //unique char count
            if (count[s.charAt(r)] == 0)
                uniqueChars++;
            //no less than k count
            if (++count[s.charAt(r)] == k)
                noLessThanK++;
            while (uniqueChars > n) {
                if (count[s.charAt(l)] == k)
                    noLessThanK--;
                if (--count[s.charAt(l)] == 0)
                    uniqueChars--;
                l++;
            }
            if (noLessThanK == n) // unique chars also == n
                result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
