package com.demo.leetcode.medium._15_decodestring_394;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [394. Decode String - MEDIUM](https://leetcode.com/problems/decode-string/)
 *
 * - stack
 * - StringBuilder.insert(0,val)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=qB0zZpBJlh8&ab_channel=NeetCode
 */
public class DecodeString {

    @Test
    public void test1() {
        Assertions.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
        Assertions.assertEquals("aaa", decodeString("3[a]"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0,stack.pop());
                }
                //remove '['
                stack.pop();
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    number.insert(0, stack.pop());
                }
                int num = Integer.parseInt(number.toString());
                String newVal = sb.toString().repeat(num);
                stack.push(newVal);
            }
        }
        return String.join("", stack);
    }
}
