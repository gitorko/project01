package com.demo.basics.concurrency._13_commonwords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Common Words - EASY]()
 *
 * - Find the most common word. Dont consider banned words.
 */
public class MostCommonWord {

    @Test
    public void test() {
        String input = "Bob hit! a ball, the? hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String expected = "ball:2";
        Assertions.assertEquals(expected, mostCommonWord(input, banned));
    }

    public String mostCommonWord(String input, String[] banned) {
        //remove extra spaces
        input = input.replaceAll("[^\\w||\\s]", "").toLowerCase();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, LongAdder> mapRef = new ConcurrentHashMap<>();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            mapRef.computeIfAbsent(token, key -> new LongAdder()).increment();
        }

        int maxCount = 0;
        String maxValue = "";
        for (Map.Entry<String, LongAdder> entry : mapRef.entrySet()) {
            if (entry.getValue().intValue() > maxCount && !bannedSet.contains(entry.getKey())) {
                maxCount = entry.getValue().intValue();
                maxValue = entry.getKey();
            }
        }
        return maxValue + ":" + maxCount;
    }
}
