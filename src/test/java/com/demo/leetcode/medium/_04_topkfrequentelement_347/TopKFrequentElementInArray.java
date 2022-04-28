package com.demo.leetcode.medium._04_topkfrequentelement_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [347. Top K Frequent Elements - MEDIUM](https://leetcode.com/problems/top-k-frequent-elements/)
 *
 * - bucket sort or max heap
 * - option 1: sort + store in map - Time O(n * log(n))
 * - option 2: sort + store in max heap + pop k times - Time O(k * log(n))
 * - option 3: Bucket sort with count as index O(n)
 * - SIMILAR_TO: [451. Sort Characters By Frequency - MEDIUM](https://leetcode.com/problems/sort-characters-by-frequency/)
 *
 * https://www.youtube.com/watch?v=YPTqKIgVk-k&ab_channel=NeetCode
 */
public class TopKFrequentElementInArray {

    @Test
    public void test1() {
        int nums[] = {1, 1, 1, 2, 2, 3}, k = 2;
        int expected[] = {1, 2};
        Assertions.assertArrayEquals(expected, topKFrequent(nums, k));
        Assertions.assertArrayEquals(expected, topKFrequent2(nums, k));
    }

    @Test
    public void test2() {
        int nums[] = {1, 2}, k = 2;
        int expected[] = {1, 2};
        Assertions.assertArrayEquals(expected, topKFrequent(nums, k));
        Assertions.assertArrayEquals(expected, topKFrequent2(nums, k));
    }

    @Test
    public void test3() {
        int nums[] = {4, 1, -1, 2, -1, 2, 3}, k = 2;
        int expected[] = {-1, 2};
        Assertions.assertArrayEquals(expected, topKFrequent(nums, k));
        Assertions.assertArrayEquals(expected, topKFrequent2(nums, k));
    }

    /**
     * max heap
     * Time: O(n * log(n))
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freqMap.entrySet());
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && k > 0) {
            Map.Entry e = maxHeap.poll();
            result.add((Integer) e.getKey());
            k--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Bucket Sort, with count as bucket index, this approach doesnt require sorting.
     * Time: O(N)
     * Space: O(N)
     */
    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        //Create frequency map
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        //Populate bucket
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        //pick from reverse
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
