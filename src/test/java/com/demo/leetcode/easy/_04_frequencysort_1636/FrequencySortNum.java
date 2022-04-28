package com.demo.leetcode.easy._04_frequencysort_1636;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1636. Sort Array by Increasing Frequency - EASY](https://leetcode.com/problems/sort-array-by-increasing-frequency/)
 *
 * - min heap
 * - SIMILAR_TO: [347. Top K Frequent Elements - MEDIUM](https://leetcode.com/problems/top-k-frequent-elements/)
 * - SIMILAR_TO: [692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)
 * - SIMILAR_TO: [451. Sort Characters By Frequency - MEDIUM](https://leetcode.com/problems/sort-characters-by-frequency/)
 */
public class FrequencySortNum {

    @Test
    public void test1() {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] expected = {3, 1, 1, 2, 2, 2};
        Assertions.assertArrayEquals(expected, frequencySort(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] expected = {5, -1, 4, 4, -6, -6, 1, 1, 1};
        Assertions.assertArrayEquals(expected, frequencySort(nums));
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        minHeap.addAll(frequencyMap.entrySet());

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Map.Entry e = minHeap.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                result.add((int) e.getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
}
