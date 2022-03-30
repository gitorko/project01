package com.demo.leetcode.easy._15_backspacestring_844;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [844. Backspace String Compare - EASY](https://leetcode.com/problems/backspace-string-compare/)
 *
 * - stack
 */
public class CheckBackSpaceString {

    @Test
    public void test() {
        Assertions.assertEquals("ac", actualString("ab#c"));
        Assertions.assertEquals("", actualString("ab#c###"));

        Assertions.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assertions.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assertions.assertTrue(backspaceCompare("a##c", "#a#c"));
        Assertions.assertFalse(backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        return actualString(s1).equals(actualString(s2));
    }

    public String actualString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
