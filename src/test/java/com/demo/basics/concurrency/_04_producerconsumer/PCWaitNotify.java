package com.demo.basics.concurrency._04_producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Produce Consumer - EASY]()
 *
 * - wait & notify
 */
public class PCWaitNotify {

    @SneakyThrows
    @Test
    public void test() {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>();
        Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                queue.put(String.valueOf(i));
                System.out.println("Published: " + i);
            }
            queue.put("END");
        };

        Runnable consumer = () -> {
            while (true) {
                String val = queue.take();
                if (val.equals("END")) break;
                System.out.println("Consumed: " + val);
            }
        };

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        p.start();
        c.start();
        System.out.println("Producer and Consumer has been started");
        p.join();
        c.join();
        System.out.println("Completed");
    }

    class MyBlockingQueue<E> {
        private Queue<E> queue = new LinkedList<>();
        private int QUEUE_SIZE = 5;

        public void put(E e) {
            synchronized (queue) {
                try {
                    if (queue.size() == QUEUE_SIZE) {
                        queue.wait();
                    }
                    queue.add(e);
                    queue.notifyAll();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public E take() {
            synchronized (queue) {
                try {
                    while (queue.size() == 0) {
                        queue.wait();
                    }
                    E item = queue.remove();
                    queue.notifyAll();
                    return item;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}


