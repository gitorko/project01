package com.demo.basics.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [622. Design Circular Queue - MEDIUM](https://leetcode.com/problems/design-circular-queue/)
 *
 * https://www.youtube.com/watch?v=aBbsfn863oA&ab_channel=NeetCode
 */
public class CircularQueue {

    @Test
    public void test() {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        Assertions.assertTrue(myCircularQueue.enQueue(1));
        Assertions.assertTrue(myCircularQueue.enQueue(2));
        Assertions.assertTrue(myCircularQueue.enQueue(3));
        Assertions.assertFalse(myCircularQueue.enQueue(4));
        Assertions.assertEquals(3, myCircularQueue.Rear());
        Assertions.assertTrue(myCircularQueue.isFull());
        Assertions.assertTrue(myCircularQueue.deQueue());
        Assertions.assertTrue(myCircularQueue.enQueue(4));
        Assertions.assertEquals(4, myCircularQueue.Rear());
    }

    class MyCircularQueue {
        int size;
        int[] queue;
        int count = 0;
        int front = 0;
        int rear;

        public MyCircularQueue(int size) {
            this.size = size;
            this.queue = new int[size];
            this.rear = size - 1;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            rear = ++rear % size;
            queue[rear] = value;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            front = ++front % size;
            count--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[rear];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }
    }
}
