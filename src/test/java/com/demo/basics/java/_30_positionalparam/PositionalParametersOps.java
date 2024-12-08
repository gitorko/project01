package com.demo.basics.java._30_positionalparam;

import java.util.Date;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class PositionalParametersOps {
    @Test
    public void test() {
        var payload = """
                       Hello %1$s 
                       Today is %2$s
                       Thanks %1$s
                """;
        var result = payload.formatted("jack", new Date());
        System.out.println(result);
    }

    @Test
    public void test2() {
        var payload = """
                       Hello Jack
                       Today is Sunday
                       Thanks
                """;
        String result = payload.lines()
                .filter(l -> l.contains("Today"))
                .findAny()
                .orElse("Not Found!");
        System.out.println(result);
    }

    @Test
    public void test3() {
        IntStream.range(0, 10)
                .mapToObj("%03d"::formatted)
                .forEach(System.out::println);
    }
}
