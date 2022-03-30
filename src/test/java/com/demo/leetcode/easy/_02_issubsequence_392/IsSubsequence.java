package com.demo.leetcode.easy._02_issubsequence_392;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [392. Is Subsequence - EASY](https://leetcode.com/problems/is-subsequence/)
 *
 * - two pointer
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=99RVfqklbCE&ab_channel=NeetCode
 */
public class IsSubsequence {

    @Test
    public void test() {
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("axc", "ahbgdc"));
    }

    /**
     * Time: O(s+t)
     */
    public boolean isSubsequence(String s, String t) {
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
