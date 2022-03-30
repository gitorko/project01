package com.demo.basics.concurrency._04_producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Produce Consumer - EASY]()
 *
 * - locks
 */
public class PCLock {

    @SneakyThrows
    @Test
    public void test() {

        MyBlockingQueue<String> queue = new MyBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(2);
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    queue.put(String.valueOf(i));
                    System.out.println("Published: " + i);
                }
                queue.put("END");
            } finally {
                latch.countDown();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    //TimeUnit.SECONDS.sleep(3);
                    String val = queue.take();
                    if (val.equals("END")) break;
                    System.out.println("Consumed: " + val);
                }
            } catch (Exception ex) {
                //Do Nothing
            } finally {
                latch.countDown();
            }
        };
        executor.submit(producer);
        executor.submit(consumer);
        latch.await();

    }

    class MyBlockingQueue<E> {
        private Queue<E> queue = new LinkedList<>();
        private int QUEUE_SIZE = 5;
        private Lock lock = new ReentrantLock(true);
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();

        public void put(E e) {
            lock.lock();
            try {
                if (queue.size() == QUEUE_SIZE) {
                    notFull.await();
                }
                queue.add(e);
                notEmpty.signalAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public E take() {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notEmpty.await();
                }
                E item = queue.remove();
                notFull.signalAll();
                return item;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                lock.unlock();
            }
        }
    }
}


