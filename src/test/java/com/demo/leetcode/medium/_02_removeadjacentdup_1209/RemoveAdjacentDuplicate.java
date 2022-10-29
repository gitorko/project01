package com.demo.leetcode.medium._02_removeadjacentdup_1209;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1209. Remove All Adjacent Duplicates in String II - MEDIUM](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
 *
 * - stack
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=w6LcypDgC4w&ab_channel=NeetCode
 */
public class RemoveAdjacentDuplicate {

    @Test
    public void test1() {
        Assertions.assertEquals("abcd", removeDuplicates("abcd", 2));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("aa", removeDuplicates("deeedbbcccbdaa", 3));
    }

    @Test
    public void test3() {
        Assertions.assertEquals("ps", removeDuplicates("pbbcggttciiippooaais", 2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public String removeDuplicates(String s, int k) {
        Stack<CustomPair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.add(new CustomPair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(e -> {
            sb.append(String.valueOf(e.c).repeat(e.count));
        });
        return sb.toString();
    }

    class CustomPair {
        private char c;
        private int count;

        public CustomPair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
