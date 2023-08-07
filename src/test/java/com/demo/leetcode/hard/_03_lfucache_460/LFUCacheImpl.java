package com.demo.leetcode.hard._03_lfucache_460;

import java.util.HashMap;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [460. LFU Cache - HARD](https://leetcode.com/problems/lfu-cache/)
 *
 * - double linked list + map
 *
 * https://www.youtube.com/watch?v=bLEIHn-DgoA&ab_channel=NeetCodeIO
 */
public class LFUCacheImpl {

    @Test
    public void test() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assertions.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assertions.assertEquals(-1, cache.get(2));
        Assertions.assertEquals(3, cache.get(3));
        cache.put(4, 4);
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(3, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));
    }

    class LFUCache {
        //[key, value]
        HashMap<Integer, Integer> dataMap;
        //[frequency, key]
        HashMap<Integer, Integer> freqMap;
        //[frequency, [key1, key2, key3]]
        HashMap<Integer, LinkedHashSet<Integer>> lists;
        int capacity;
        int minFreq = -1;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            dataMap = new HashMap<>();
            freqMap = new HashMap<>();
            lists = new HashMap<>();
            lists.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!dataMap.containsKey(key)) {
                return -1;
            }
            int count = freqMap.get(key);
            //increase freq count
            freqMap.put(key, count + 1);
            //remove from old freq list
            lists.get(count).remove(key);
            //if list becomes empty
            if (count == minFreq && lists.get(count).size() == 0) {
                minFreq++;
            }
            //add empty set for next frequency
            if (!lists.containsKey(count + 1)) {
                lists.put(count + 1, new LinkedHashSet<>());
            }
            lists.get(count + 1).add(key);
            return dataMap.get(key);
        }

        public void put(int key, int value) {
            if (dataMap.containsKey(key)) {
                dataMap.put(key, value);
                get(key);
                return;
            }
            if (dataMap.size() >= capacity) {
                int evict = lists.get(minFreq).iterator().next();
                lists.get(minFreq).remove(evict);
                dataMap.remove(evict);
            }
            dataMap.put(key, value);
            freqMap.put(key, 1);
            minFreq = 1;
            lists.get(1).add(key);
        }
    }
}
