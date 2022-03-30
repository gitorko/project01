package com.demo.leetcode.medium._01_removekdigits_402;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [402. Remove K Digits - MEDIUM](https://leetcode.com/problems/remove-k-digits/)
 *
 * - monotonic stack, keep stack in increasing order
 *
 * https://www.youtube.com/watch?v=cFabMOnJaq0&ab_channel=NeetCode
 */
public class RemoveKdigits {

    @Test
    public void test() {
        Assertions.assertEquals("1219", removeKdigits("1432219", 3));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("0", removeKdigits("10", 2));
    }

    @Test
    public void test3() {
        Assertions.assertEquals("200", removeKdigits("10200", 1));
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (Character c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        //to remove leading zero
        String result = sb.toString();
        if (result.isBlank()) {
            return "0";
        } else {
            return result.replaceFirst("^0+(?!$)", "");
        }
    }

    public String removeKdigits2(String num, int k) {
        int len = num.length();
        if (k == 0) return num;
        if (k == len) return "0";

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < len) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while (k-- > 0) stack.pop();

        String smallest = "";
        while (!stack.isEmpty()) smallest = stack.pop() + smallest;

        // delete leading zeros
        while (smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);

        return smallest;
    }
}
