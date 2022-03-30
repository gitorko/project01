package com.demo.basics.java._05_deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DequeueOps {

    @Test
    public void test() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(1);
        deque.push(2);
        deque.push(3);

        // 1. Convert to String using toString()
        System.out.println(deque.toString());

        // 2. Java 8 and above
        Stream.of(deque.toString())
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) {
            q.offer(i);
        }
        //remove from beginning of queue
        Assertions.assertEquals(1, q.poll());
        //remove from beginning of queue
        Assertions.assertEquals(2, q.pollFirst());
        //remove from beginning of queue
        Assertions.assertEquals(3, q.pop());

        //remove from end of queue
        Assertions.assertEquals(10, q.pollLast());

        //check front of queue
        Assertions.assertEquals(4, q.peek());
        //check front of queue
        Assertions.assertEquals(4, q.peekFirst());
        //check end of queue
        Assertions.assertEquals(9, q.peekLast());

        //adds to end of queue
        q.add(10);
        Assertions.assertEquals(10, q.pollLast());
        q.addLast(10);
        Assertions.assertEquals(10, q.pollLast());


        //adds to front of queue
        q.addFirst(10);
        Assertions.assertEquals(10, q.poll());
        q.addFirst(10);
        Assertions.assertEquals(10, q.pollFirst());

        //push pop happen in front of queue
        q.push(10);
        Assertions.assertEquals(10, q.pollFirst());
        q.addFirst(10);
        Assertions.assertEquals(10, q.pop());

    }
}
