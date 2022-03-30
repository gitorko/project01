package com.demo.leetcode.easy._15_stacksort;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Sort a stack - EASY]()
 *
 * - using two stack
 */
public class StackSort {

    @Test
    public void test() {
        Stack<Integer> s1 = new Stack<>();
        s1.add(8);
        s1.add(3);
        s1.add(2);
        s1.add(7);
        Stack<Integer> s2 = sortStack(s1);
        Integer[] expected = {2, 3, 7, 8};
        Assertions.assertArrayEquals(expected, s2.stream().toArray());
    }

    public Stack<Integer> sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int val = s1.pop();
            while (!s2.isEmpty() && s2.peek() > val) {
                s1.push(s2.pop());
            }
            s2.push(val);
        }
        return s2;
    }
}
