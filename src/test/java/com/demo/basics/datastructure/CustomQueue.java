package com.demo.basics.datastructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Queue - EASY]()
 *
 * - linked list
 * - front and rear pointer
 * - remember to set rear if queue is empty after poll
 */
public class CustomQueue {

    @Test
    public void test_pollOnEmpty() {
        MyQueue<String> queue = new MyQueue(3);
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.poll();
        });
        Assertions.assertEquals(0, queue.size());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void test_peekEmpty() {
        MyQueue<String> queue = new MyQueue(3);
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.peek();
        });
    }

    @Test
    public void test_exceedCapacity() {
        MyQueue<String> queue = new MyQueue(3);
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.offer("D");
        });
        Assertions.assertEquals(3, queue.size());
    }

    @Test
    public void test_poll() {
        MyQueue<String> queue = new MyQueue(3);
        Assertions.assertTrue(queue.isEmpty());
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals("A", queue.poll());
        Assertions.assertEquals("B", queue.poll());
        Assertions.assertEquals("C", queue.poll());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void test_removeAdd() {
        MyQueue<String> queue = new MyQueue(3);
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        Assertions.assertEquals("A", queue.poll());
        Assertions.assertEquals("B", queue.poll());
        Assertions.assertEquals("C", queue.poll());
        queue.offer("D");
        queue.offer("E");
        queue.offer("F");
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.offer("G");
        });
        Assertions.assertEquals(3, queue.size());
        Assertions.assertFalse(queue.isEmpty());
        System.out.println(queue);
    }

    @Test
    public void test_noCapacity() {
        MyQueue<String> queue = new MyQueue();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.offer("F");
        });
    }

    class MyQueue<T> {
        private Node<T> front;
        private Node<T> rear;
        private int capacity;
        private int count;

        MyQueue() {
            this.front = null;
            this.rear = null;
            this.capacity = 5;
        }

        MyQueue(int capacity) {
            this.front = null;
            this.rear = null;
            this.capacity = capacity;
        }

        public void offer(T data) {
            if (isFull()) {
                throw new RuntimeException("Queue is full!");
            }
            Node<T> node = new Node<>(data);
            if (isEmpty()) {
                front = node;
            } else {
                rear.next = node;
            }
            rear = node;
            count++;
        }

        public T poll() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            Node<T> result = front;
            front = front.next;
            count--;
            //remember to set rear if queue is empty
            if (isEmpty()) {
                rear = null;
            }
            return result.data;
        }

        public T peek() throws Exception {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            return front.data;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return capacity == count;
        }

        public int size() {
            return count;
        }

        @Override
        public String toString() {
            List<String> result = new ArrayList<>();
            if (isEmpty()) {
                return "";
            }
            Node<T> curr = front;
            while (curr != null) {
                result.add((String) curr.data);
                curr = curr.next;
            }
            return String.join(",", result);
        }
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
