package com.demo.leetcode.medium._15_reversepolishnotation_150;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [150. Evaluate Reverse Polish Notation - MEDIUM](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
 *
 * - stack
 *
 * https://www.youtube.com/watch?v=iu0082c4HDE&ab_channel=NeetCode
 */
public class ReversePolishNotation {

    @Test
    public void test1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Assertions.assertEquals(9, evalRPN(tokens));
    }

    @Test
    public void test2() {
        String[] tokens = {"4", "3", "-"};
        Assertions.assertEquals(1, evalRPN(tokens));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String token : tokens)
            switch (token) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        return stack.peek();
    }
}
