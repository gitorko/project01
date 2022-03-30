package com.demo.leetcode.hard._09_longestvalidparentheses;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [32. Longest Valid Parentheses - HARD](https://leetcode.com/problems/longest-valid-parentheses/)
 *
 * - stack with index
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=VdQuwtEd10M&ab_channel=AlgorithmsMadeEasy
 */
public class LongestValidParentheses {

    @Test
    public void test() {
        Assertions.assertEquals(2, longestValidParentheses("(()"));
        Assertions.assertEquals(2, longestValidParentheses("()"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }
}
