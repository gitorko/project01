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

}
