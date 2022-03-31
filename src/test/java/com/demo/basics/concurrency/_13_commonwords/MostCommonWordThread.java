package com.demo.basics.concurrency._13_commonwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * [Common Words multi thread - MEDIUM]()
 *
 * - map reduce
 * - multi thread
 * - Find the most common word. Dont consider banned words.
 */
public class MostCommonWordThread {

    @SneakyThrows
    @Test
    public void test() {
        String input = "Bob hit! a ball.\nThe ball flew far after it was hit.\nIt landed outside the field.";
        Set bannedSet = Set.of("hit");
        Map<String, Integer> result = findCommonWord(input, bannedSet);
        Assertions.assertEquals(2, result.get("ball"));
    }

    public Map<String, Integer> findCommonWord(String input, Set banned) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Map<String, Integer> mapRef = new HashMap<>();
        List<Future<Map<String, Integer>>> futureLst = new ArrayList<>();
        for (String line : input.split("\n")) {
            System.out.println("Submitting Job: " + line);
            Future<Map<String, Integer>> future = executor.submit(new ProcessingJob(line, banned));
            futureLst.add(future);
        }
        for (Future<Map<String, Integer>> future : futureLst) {
            Map<String, Integer> resultMap = future.get();
            for (Map.Entry<String, Integer> result : resultMap.entrySet()) {
                mapRef.put(result.getKey(), mapRef.getOrDefault(result.getKey(), 0) + result.getValue());
            }
        }
        executor.shutdown();
        System.out.println(Thread.currentThread() + ":" + mapRef);
        return mapRef;
    }

    class ProcessingJob implements Callable<Map<String, Integer>> {
        String line;
        Set bannedSet;

        public ProcessingJob(String line, Set bannedSet) {
            this.line = line;
            this.bannedSet = bannedSet;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> mapRef = new HashMap<>();
            line = line.replaceAll("[^\\w||\\s]", "").toLowerCase();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                if (!bannedSet.contains(token) && !token.equals("")) {
                    mapRef.put(token, mapRef.getOrDefault(token, 0) + 1);
                }
            }
            System.out.println(Thread.currentThread() + ":" + mapRef);
            return mapRef;
        }
    }
}
