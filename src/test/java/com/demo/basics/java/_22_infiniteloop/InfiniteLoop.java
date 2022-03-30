package com.demo.basics.java._22_infiniteloop;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InfiniteLoop {

    @Test
    public void test_timeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            //Assertions.assertEquals(4, square(2));
        });
    }

    @Test
    public void test_withoutTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Assertions.assertEquals(9, square(3));
        });
    }

    public int square(int x) {
        if (x == 2) {
            while (true) ;
        }
        return x * x;
    }
}
