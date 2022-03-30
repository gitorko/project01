package com.demo.basics.puzzle._010_volatile;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VolatilePuzzleFix {

    private volatile boolean sayHello = false;

    @Test
    public void test() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            sayHello();
        });
    }

    public void sayHello() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!sayHello) {
            }
            System.out.println("Hello World!");
            while (sayHello) {
            }
            System.out.println("Good Bye!");
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        sayHello = true;
        TimeUnit.SECONDS.sleep(1);
        sayHello = false;
        thread.join();
    }
}
