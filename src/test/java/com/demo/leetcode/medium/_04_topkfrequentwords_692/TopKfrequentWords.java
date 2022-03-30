package com.demo.leetcode.medium._04_topkfrequentwords_692;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [692. Top K Frequent Words - MEDIUM](https://leetcode.com/problems/top-k-frequent-words/)
 *
 * - heap, result add 0 position
 * - lexo graphical order.
 * - bucket sort (but cant maintain lexo graphical order without sort) so use heap
 * - SIMILAR_TO: [347. Top K Frequent Elements - MEDIUM](https://leetcode.com/problems/top-k-frequent-elements/)
 */
public class TopKfrequentWords {

    @Test
    public void test() {
        String words[] = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> expected = Arrays.asList("i", "love");
        Assertions.assertEquals(expected, topKFrequent(words, 2));
    }

    @Test
    public void test2() {
        String words[] = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> expected = Arrays.asList("the", "is", "sunny", "day");
        Assertions.assertEquals(expected, topKFrequent(words, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        //To maintain lexo-graphical order
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
