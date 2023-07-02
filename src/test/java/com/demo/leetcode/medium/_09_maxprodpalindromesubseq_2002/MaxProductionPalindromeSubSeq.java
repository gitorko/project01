package com.demo.leetcode.medium._09_maxprodpalindromesubseq_2002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2002. Maximum Product of the Length of Two Palindromic Subsequences - MEDIUM](https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/)
 *
 * https://www.youtube.com/watch?v=aoHbYlO8vDg&ab_channel=NeetCode
 */
public class MaxProductionPalindromeSubSeq {

    @Test
    public void test() {
        String s = "leetcodecom";
        Assertions.assertEquals(9, maxProduct(s));
    }

    /**
     * Time: O(3^n * n)
     */
    int result = 0;

    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        dfs(c, 0, "", "");
        return result;
    }

    public void dfs(char[] c, int i, String s1, String s2) {
        if (i >= c.length) {
            if (isPalindrome(s1) && isPalindrome(s2)) {
                result = Math.max(result, s1.length() * s2.length());
            }
            return;
        }
        dfs(c, i + 1, s1 + c[i], s2);
        dfs(c, i + 1, s1, s2 + c[i]);
        dfs(c, i + 1, s1, s2);
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
