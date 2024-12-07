package com.demo.basics.java._30_positionalparam;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class PositionalParameters {
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
}
