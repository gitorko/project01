package com.demo.basics.datastructure;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [225. Implement Stack using Queues - EASY](https://leetcode.com/problems/implement-stack-using-queues/)
 *
 * - push rearranges the queue again each time, so pop is O(1)
 *
 * https://www.youtube.com/watch?v=rW4vm0-DLYc&ab_channel=NeetCode
 */
public class StackUsingQueue {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        Assertions.assertEquals(2, myStack.top());
        Assertions.assertEquals(2, myStack.pop());
        Assertions.assertFalse(myStack.empty());
    }

    class MyStack {
        Queue<Integer> q = new LinkedList<>();

        // Push element x onto stack.
        public void push(int x) {
            q.add(x);

            //Remove from front of queue and add to back till the last but one element.
            int n = q.size();
            while (n > 1) {
                q.add(q.poll());
                n--;
            }
        }

        // Removes the element on top of the stack.
        public int pop() {
            return q.poll();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }

    }

}
