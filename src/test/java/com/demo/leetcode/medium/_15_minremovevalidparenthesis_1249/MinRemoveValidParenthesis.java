package com.demo.leetcode.medium._15_minremovevalidparenthesis_1249;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1249. Minimum Remove to Make Valid Parentheses - MEDIUM](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)
 *
 * - stack holds index
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=sClFsx12VgM&ab_channel=AlgorithmsMadeEasy
 */
public class MinRemoveValidParenthesis {

    @Test
    public void test() {
        Assertions.assertEquals("lee(t(c)o)de", minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>(); // unpaired '(' indices
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); ++i) {
            if (sb.charAt(i) == '(') {
                stack.push(i); // record unpaired '(' index
            } else if (sb.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb.setCharAt(i, '#'); // mark unpaired ')' as '#'
                } else {
                    stack.pop(); // find a pair!
                }
            }
        }
        // mark unpaired '(' as '#'
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '#');
        }
        return sb.toString().replaceAll("#", "");
    }
}
