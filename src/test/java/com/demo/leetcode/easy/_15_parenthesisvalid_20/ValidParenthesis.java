package com.demo.leetcode.easy._15_parenthesisvalid_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [20. Valid Parentheses - EASY](https://leetcode.com/problems/valid-parentheses/)
 *
 * - stack + map
 * - edge case - don't pop from empty stack
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=WTzjTskDFMg&ab_channel=NeetCode
 */
public class ValidParenthesis {

    @Test
    public void test1() {
        Assertions.assertTrue(isValid("{}"));
        Assertions.assertTrue(isValid("()[]{}"));
        Assertions.assertTrue(isValid("[({})]"));
        Assertions.assertTrue(isValid(""));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isValid("{}}]"));
        Assertions.assertFalse(isValid("}{"));
        Assertions.assertFalse(isValid("[({)(})]"));
        Assertions.assertFalse(isValid("["));
        Assertions.assertFalse(isValid("[(])"));
    }

    /**
     * Without map
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * With map
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> tokenStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if (map.get(token) != null) {
                tokenStack.push(token);
            } else {
                if (tokenStack.isEmpty()) {
                    return false;
                }
                if (map.get(tokenStack.pop()) != token) {
                    return false;
                }
            }
        }
        return tokenStack.isEmpty();
    }

}
