package com.demo.leetcode.easy._15_minstack_155;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [155. Min Stack - EASY](https://leetcode.com/problems/min-stack/)
 *
 * - stack, pair
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=qkLl7nAwDPo&ab_channel=NeetCode
 */
public class MinStack {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        minStack.top();
        Assertions.assertEquals(-2, minStack.getMin());
    }

    /**
     * Time: O(1)
     * Space: O(n)
     *
     * holds {x, min}
     */
    Stack<int[]> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
