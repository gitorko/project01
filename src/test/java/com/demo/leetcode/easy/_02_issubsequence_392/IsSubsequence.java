package com.demo.leetcode.easy._02_issubsequence_392;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [392. Is Subsequence - EASY](https://leetcode.com/problems/is-subsequence/)
 *
 * - two pointer
 * - SIMILAR_TO: [28. Implement strStr - MEDIUM](https://leetcode.com/problems/implement-strstr/)
 * - PRACTICE: P2
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
     * Space: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = 0;
        while (left < s.length() && right < t.length()) {
            if (t.charAt(right) == s.charAt(left)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }
}
