package com.demo.leetcode.medium._13_maxremovablechar_1898;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1898. Maximum Number of Removable Characters - MEDIUM](https://leetcode.com/problems/maximum-number-of-removable-characters/)
 *
 * - binary search
 * - SIMILAR_TO: [392. Is Subsequence - EASY](https://leetcode.com/problems/is-subsequence/)
 *
 * https://www.youtube.com/watch?v=NMP3nRPyX5g&ab_channel=NeetCode
 */
public class MaxRemoveableChars {

    @Test
    public void test() {
        String s = "abcacb", p = "ab";
        int[] removable = {3, 1, 0};
        Assertions.assertEquals(2, maximumRemovals(s, p, removable));
    }

    /**
     * Time: O(nlogn)
     * Space: O(n)
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            String removed = remove(s, removable, mid + 1);
            if (isSubsequence(p, removed))
                left = mid + 1;
            else
                right = mid -1;
        }
        return left;
    }

    private String remove(String s, int[] removable, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < k; i++)
            sb.setCharAt(removable[i], '*');
        return sb.toString();
    }

    private boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
