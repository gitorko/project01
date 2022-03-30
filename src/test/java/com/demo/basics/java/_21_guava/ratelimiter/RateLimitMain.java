package com.demo.basics.java._21_guava.ratelimiter;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/guava-rate-limiter
 * https://www.baeldung.com/spring-bucket4j
 * https://resilience4j.readme.io/docs/ratelimiter
 */
public class RateLimitMain {

    @Test
    public void test1() {
        RateLimiter rateLimiter = RateLimiter.create(2);
        IntStream.range(0, 5).forEach(i -> {
            System.out.println("Starting " + i);
            rateLimiter.acquire();
            new Thread(() -> {
                System.out.println("Called " + Thread.currentThread().getName());
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RateLimitMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Completed " + Thread.currentThread().getName());
            }).start();

        });
    }

}
