package com.demo.basics.datastructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Stack - EASY]()
 *
 * - top pointer
 */

public class CustomStack {

    @Test
    public void test_popOnEmpty() {
        MyStack<String> stack = new MyStack<>();
        Assertions.assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertThrows(RuntimeException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void test_exceedCapacity() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Assertions.assertThrows(RuntimeException.class, () -> {
            stack.push("D");
        });
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertTrue(stack.isFull());
    }

    @Test
    public void test_peek() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Assertions.assertThrows(RuntimeException.class, () -> {
            stack.push("D");
        });
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals("C", stack.peek());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    public void test_addRemove() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Assertions.assertEquals("C", stack.pop());
        Assertions.assertEquals("B", stack.pop());
        Assertions.assertEquals("A", stack.pop());
        Assertions.assertThrows(RuntimeException.class, () -> {
            stack.pop();
        });
        stack.push("D");
        stack.push("E");
        stack.push("F");
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals("F", stack.peek());
        System.out.println(stack);
    }

    class MyStack<T> {

        private int count;
        private Node<T> top;
        private int capacity;

        MyStack() {
            this.capacity = 5;
        }

        MyStack(int capacity) {
            this.capacity = capacity;
        }

        public void push(T value) {
            if (isFull()) {
                throw new RuntimeException("Stack is full!");
            }
            Node<T> node = new Node<>(value);
            if (isEmpty()) {
                top = node;
            } else {
                node.previous = top;
                top = node;
            }
            count++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            Node<T> temp = top;
            top = top.previous;
            count--;
            return temp.data;
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == capacity;
        }

        public int size() {
            return count;
        }

        @Override
        public String toString() {
            List<String> result = new ArrayList<>();
            Node curr = top;
            while (curr != null) {
                result.add((String) curr.data);
                curr = curr.previous;
            }
            return String.join(",", result);
        }
    }

    class Node<T> {
        T data;
        Node<T> previous;

        public Node(T data) {
            this.data = data;
        }
    }
}


