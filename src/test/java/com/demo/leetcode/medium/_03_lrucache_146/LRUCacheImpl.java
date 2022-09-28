package com.demo.leetcode.medium._03_lrucache_146;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [146. LRU Cache - MEDIUM](https://leetcode.com/problems/lru-cache/)
 *
 * - double linked list + map
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=7ABFKPK2hD4&ab_channel=NeetCode
 */
public class LRUCacheImpl {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
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

    class LRUCache {
        Map<Integer, Node> map;
        Node front;
        Node rear;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            front = rear = null;
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            Node curr = map.get(key);
            remove(curr);
            addFirst(curr);
            return curr.value;
        }

        public void put(int key, int value) {
            Node curr = map.containsKey(key) ? map.get(key) : null;
            if (curr == null) {
                curr = new Node(key, value);
                addFirst(curr);
                map.put(key, curr);
            } else {
                curr.value = value;
                remove(curr);
                addFirst(curr);
            }
            if (map.size() > capacity) {
                curr = removeLast();
                map.remove(curr.key);
            }
        }

        private void addFirst(Node curr) {
            if (front == null) {
                front = rear = curr;
                return;
            }
            front.left = curr;
            curr.right = front;
            front = curr;
        }

        private void remove(Node curr) {
            if (front == curr && rear == curr) {
                front = rear = null;
                return;
            }
            if (front == curr) {
                front = front.right;
                front.left = null;
                return;
            }
            if (rear == curr) {
                rear = rear.left;
                rear.right = null;
                return;
            }
            Node prev = curr.left;
            Node next = curr.right;
            prev.right = next;
            next.left = prev;
        }

        private Node removeLast() {
            if (front == rear) {
                Node temp = front;
                front = rear = null;
                return temp;
            }
            Node temp = rear;
            rear = rear.left;
            rear.right = null;
            return temp;
        }

        class Node {
            int value;
            int key;
            Node left;
            Node right;

            public Node(int key, int value) {
                this.value = value;
                this.key = key;
                left = right = null;
            }

        }
    }

}
