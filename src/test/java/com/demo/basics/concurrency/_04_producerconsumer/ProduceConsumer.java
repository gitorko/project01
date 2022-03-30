package com.demo.basics.concurrency._04_producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * [Produce Consumer - EASY]()
 *
 * - blocking queue
 */
public class ProduceConsumer {

    @SneakyThrows
    @Test
    public void test() {
        // BlockingQueue<String> queue = new SynchronousQueue<>();
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(String.valueOf(i));
                    System.out.println("Published: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put("END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    //TimeUnit.SECONDS.sleep(3);
                    String val = queue.take();
                    if (val.equals("END")) break;
                    System.out.println("Consumed: " + val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
}
