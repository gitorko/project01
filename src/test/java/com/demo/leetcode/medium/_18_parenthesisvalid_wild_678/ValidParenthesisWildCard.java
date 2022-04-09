package com.demo.leetcode.medium._18_parenthesisvalid_wild_678;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [678. Valid Parenthesis String - MEDIUM](https://leetcode.com/problems/valid-parenthesis-string/)
 *
 * - two variables (leftMin, leftMax)
 * - greedy
 *
 * https://www.youtube.com/watch?v=QhPdNS143Qg&ab_channel=NeetCode
 */
public class ValidParenthesisWildCard {

    @Test
    public void test() {
        Assertions.assertTrue(checkValidString("()"));
        Assertions.assertTrue(checkValidString("(*)"));
        Assertions.assertTrue(checkValidString("(*))"));
        Assertions.assertFalse(checkValidString("(*)("));
        Assertions.assertFalse(checkValidString("))(("));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
