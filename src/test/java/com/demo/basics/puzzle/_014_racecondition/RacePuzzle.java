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

public class RacePuzzle {

    Map<String, String> bookMap = new HashMap<>();

    @Test
    public void test() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Callable<Void>> tasks = new ArrayList<>();
        tasks.add(() -> {
            if (!bookMap.containsKey("book1")) {
                bookMap.put("book1", "user3");
            }
            return null;
        });
        tasks.add(() -> {
            if (!bookMap.containsKey("book1")) {
                bookMap.put("book1", "user5");
            }
            return null;
        });
        executor.invokeAll(tasks, 5, TimeUnit.SECONDS);
        System.out.println(bookMap.get("book1"));
    }
}
