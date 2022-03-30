package com.demo.basics.puzzle._014_racecondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * Data Race vs Race Condition
 *
 * 1. Check & Update
 * 2. Read & Update
 *
 * https://www.youtube.com/watch?v=KGnXr62bgHM&ab_channel=DefogTech
 */
public class RacePuzzleFix {

    Map<String, String> bookMap = new HashMap<>();

    @Test
    public void test() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> tasks = new ArrayList<>();
        tasks.add(() -> {
            bookMap.putIfAbsent("book1", "user3");
            return null;
        });
        tasks.add(() -> {
            bookMap.putIfAbsent("book1", "user5");
            return null;
        });
        executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
        System.out.println(bookMap.get("book1"));
    }
}
