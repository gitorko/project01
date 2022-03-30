package com.demo.basics.concurrency._08_evenodd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Print Even Odd - EASY]()
 *
 * - wait notify
 */
public class EvenOdd {

    @SneakyThrows
    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList(Arrays.asList(2, 1, 3, 4, 5, 7, 9, 12));
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            new PrintTask(queue, e -> (e % 2 == 0));
        });
        executor.execute(() -> {
            new PrintTask(queue, e -> (e % 2 != 0));
        });
    }

    @AllArgsConstructor
    class PrintTask implements Runnable {

        Queue<Integer> queue;
        Predicate<Integer> check;

        @SneakyThrows
        @Override
        public void run() {
            synchronized (queue) {
                while (!queue.isEmpty()) {

                    Integer element = queue.peek();
                    if (check.test(element)) {
                        queue.remove();
                        System.out.println(Thread.currentThread().getName() + " -> " + element);
                    } else {
                        //wait
                        queue.notifyAll();
                        queue.wait();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Completed!");
                queue.notifyAll();
            }
        }
    }

}

