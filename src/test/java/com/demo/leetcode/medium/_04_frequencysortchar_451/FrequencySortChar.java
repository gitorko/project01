package com.demo.leetcode.medium._04_frequencysortchar_451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [451. Sort Characters By Frequency - MEDIUM](https://leetcode.com/problems/sort-characters-by-frequency/)
 *
 * - bucket sort or heap
 * - SIMILAR_TO: [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)
 * - SIMILAR_TO: [347. Top K Frequent Elements - MEDIUM](https://leetcode.com/problems/top-k-frequent-elements/)
 * - SIMILAR_TO: [1636. Sort Array by Increasing Frequency - EASY](https://leetcode.com/problems/sort-array-by-increasing-frequency/)
 */
public class FrequencySortChar {

    @Test
    public void test() {
        Assertions.assertEquals("eert", frequencySort("tree"));
        Assertions.assertEquals("eert", frequencySort2("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(frequencyMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    /**
     * bucket sort
     */
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }

}
