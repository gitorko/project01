package com.demo.leetcode.hard._09_regularexpression_10;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [10. Regular Expression Matching - HARD](https://leetcode.com/problems/regular-expression-matching/)
 *
 * - dp
 *
 * https://www.youtube.com/watch?v=HAA8mgxlov8&ab_channel=NeetCode
 */
public class RegularExpression {

    @Test
    public void test1() {
        String s = "aa", p = "a";
        Assertions.assertFalse(isMatch(s, p));
    }

    @Test
    public void test2() {
        String s = "aa", p = "a*";
        Assertions.assertTrue(isMatch(s, p));
    }

    @Test
    public void test3() {
        String s = "ab", p = ".*";
        Assertions.assertTrue(isMatch(s, p));
    }

    @Test
    public void test4() {
        String s = "aabcd", p = "a.b.*";
        Assertions.assertTrue(isMatch(s, p));
    }

    @Test
    public void test5() {
        String s = "aabc", p = ".*";
        Assertions.assertTrue(isMatch(s, p));
    }

    @Test
    public void test6() {
        String s = "", p = ".";
        Assertions.assertFalse(isMatch(s, p));
    }

    @Test
    public void test7() {
        String s = "", p = ".*";
        Assertions.assertTrue(isMatch(s, p));
    }

    /**
     * Time: O(n * m)
     * Space: O(n * m)
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j < p.length() + 1; j++) {
            //when we encounter '.*' or 'a*' it can be empty, so we consider [j-2]
            dp[0][j] = getCurrChar(p, j) == '*' && dp[0][j - 2];
        }
        for (int j = 1; j < p.length() + 1; j++) {
            for (int i = 1; i < s.length() + 1; i++) {
                if (getCurrChar(p, j) == getCurrChar(s, i) || getCurrChar(p, j) == '.') {
                    //exact match go diagonal
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (getCurrChar(p, j) == '*') {
                    //when we encounter '.*' or 'a*' it can be empty, so we consider [j-2]
                    //If not empty then 2 cases
                    //1. previous char is same eg: a matches with a* and dp[i-1]
                    //2. previous char is '.' eg: a matches with .* and dp[i-1]
                    dp[i][j] = dp[i][j - 2] || ((getCurrChar(s, i) == getPrevChar(p, j) || getPrevChar(p, j) == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * Since we have to -1 each time to avoid confusion it's converted to function
     */
    private char getCurrChar(String c, int i) {
        return c.charAt(i - 1);
    }

    /**
     * Since we have to -2 each time to avoid confusion it's converted to function
     */
    private char getPrevChar(String c, int i) {
        return c.charAt(i - 2);
    }
}
