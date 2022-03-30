package com.demo.leetcode.medium._03_lrucache_146;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [146. LRU Cache - MEDIUM](https://leetcode.com/problems/lru-cache/)
 *
 * - double linked list + map
 * - use deque but it is not optimized for remove. Will timeout for large set.
 * - this solution below is for understanding concept
 *
 * https://www.youtube.com/watch?v=7ABFKPK2hD4&ab_channel=NeetCode
 */
public class LRUCacheConcept {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        // returns -1  (not found)
        Assertions.assertEquals(-1, cache.get(1));
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        //exceeding capacity without doing get.  evicts 1
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(2, cache.get(2));
        // evicts key 2
        cache.put(4, 4);
        Assertions.assertEquals(-1, cache.get(3));
    }

    /**
     * Helps understand concept. Not to be used as remove is not optimal, takes O(n) to remove.
     */
    class LRUCache {
        int capacity;
        Map<Integer, Node> map;
        Deque<Node> dq;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dq = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            Node curr = map.get(key);
            // Take O(n) time. Not optimized for remove.
            dq.remove(curr);
            dq.addFirst(curr);
            return curr.value;
        }

        public void put(int key, int value) {
            Node curr = map.containsKey(key) ? map.get(key) : null;
            if (curr == null) {
                curr = new Node(key, value);
                dq.addFirst(curr);
                map.put(key, curr);
            } else {
                curr.value = value;
                dq.remove(curr);
                dq.addFirst(curr);
            }
            if (map.size() > capacity) {
                curr = dq.removeLast();
                map.remove(curr.key);
            }
        }
    }

    @Data
    @AllArgsConstructor
    class Node {
        int key;
        int value;
    }

}


