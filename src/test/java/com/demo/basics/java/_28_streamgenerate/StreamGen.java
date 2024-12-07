package com.demo.basics.java._28_streamgenerate;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamGen {
    @Test
    public void test() {
        Stream.generate(() -> "Hello World!")
                .limit(5)
                .forEach(System.out::println);
        Stream.generate(() -> new Date())
                .limit(5)
                .forEach(e -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(e);
                });
    }
}
