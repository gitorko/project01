package com.demo.basics.concurrency._08_evenodd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Print Even Odd - EASY]()
 *
 * - thread1 should print even number, thread2 should print odd numbers
 * - wait notify
 * - SIMILAR_TO: [1116. Print Zero Even Odd - MEDIUM](https://leetcode.com/problems/print-zero-even-odd/)
 */
public class EvenOdd {

    @SneakyThrows
    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList(Arrays.asList(2, 1, 3, 4, 5, 7, 9, 12));
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(2);
        Semaphore signalFlag = new Semaphore(1);
        executor.execute(new PrintTask(queue, e -> (e % 2 == 0), latch, signalFlag));
        executor.execute(new PrintTask(queue, e -> (e % 2 != 0), latch, signalFlag));
        latch.await();
    }

    @AllArgsConstructor
    class PrintTask implements Runnable {

        Queue<Integer> queue;
        Predicate<Integer> check;
        CountDownLatch latch;
        Semaphore signalFlag;

        @SneakyThrows
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                Integer element = queue.peek();
                signalFlag.acquire();
                if (check.test(element)) {
                    queue.remove();
                    System.out.println(Thread.currentThread().getName() + " -> " + element);
                }
                signalFlag.release();
            }
            System.out.println(Thread.currentThread().getName() + " Completed!");
            latch.countDown();
        }
    }

}

