package com.demo.basics.concurrency._13_commonwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * [Common Words multi thread - MEDIUM]()
 *
 * - multi thread
 * - Find the most common word. Dont consider banned words.
 */
public class MostCommonWordThread {

    @Test
    public void test() {
        String input = "Bob hit! a ball, the? hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        bannedSet = new HashSet<>(Arrays.asList(banned));
        findCommonWord(input, banned);
        Assertions.assertEquals(2, mapRef.get("ball"));
    }

    Map<String, Integer> mapRef = new ConcurrentHashMap<>();
    Set<String> bannedSet = null;

    public void findCommonWord(String input, String[] banned) {
        ExecutorService svc = Executors.newCachedThreadPool();
        List<Runnable> jobs = new ArrayList<>();
        int startIndex = 0;
        int chunkIndex = input.indexOf(" ", 10);
        while (true) {
            String chunk = input.substring(startIndex, chunkIndex);
            Runnable runnable = () -> {
                mostCommonWord(chunk);
            };
            jobs.add(runnable);
            startIndex = chunkIndex;
            chunkIndex = input.indexOf(" ", chunkIndex + 10);
            chunkIndex = chunkIndex == -1 ? input.length() : chunkIndex;
            if (startIndex == input.length())
                break;
        }

        for (Runnable job : jobs) {
            svc.execute(job);
        }

        svc.shutdown();
        while (!svc.isTerminated()) {
        }

        mapRef.entrySet().forEach(e -> {
            System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue());
        });
    }

    public void mostCommonWord(String input) {
        input = input.replaceAll("[^\\w||\\s]", "").toLowerCase();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (!bannedSet.contains(token) && !token.equals("")) {
                mapRef.compute(token, (key, value) -> value == null ? 1 : value + 1);
            }
        }
    }
}
