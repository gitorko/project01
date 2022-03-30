package com.demo.leetcode.easy._15_minstack_155;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinStackElement {

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
     * use 2 stack, can be reduced to one stack if both value,min are stored in single stack
     */
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(minStack.peek(), x));
            }
        }

        public int pop() {
            minStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

    }
}
