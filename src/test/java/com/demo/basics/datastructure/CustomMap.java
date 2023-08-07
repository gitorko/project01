package com.demo.basics.datastructure;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [706. Design HashMap - EASY](https://leetcode.com/problems/design-hashmap/)
 *
 * - doesnt resize, no rehashing
 *
 * https://www.youtube.com/watch?v=cNWsgbKwwoU&ab_channel=NeetCodeIO
 */
public class CustomMap {

    @Test
    public void test() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        Assertions.assertEquals(1, myHashMap.get(1)); // return 1, The map is now [[1,1], [2,2]]
        Assertions.assertEquals(-1, myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        Assertions.assertEquals(1, myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        Assertions.assertEquals(-1, myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]
    }

    class MyHashMap {

        MapEntry[] bucket;

        MyHashMap() {
            bucket = new MapEntry[10000];
            //first node is dummy node
            Arrays.fill(bucket, new MapEntry(-1, -1));
        }

        public void put(int key, int value) {
            MapEntry curr = bucket[getHash(key)];
            while (curr.next != null) {
                if (curr.next.key == key) {
                    curr.next.val = value;
                    return;
                }
                curr = curr.next;
            }
            curr.next = new MapEntry(key, value);
        }

        public int get(int key) {
            MapEntry curr = bucket[getHash(key)];
            while (curr != null) {
                if (curr.key == key) {
                    return curr.val;
                }
                curr = curr.next;
            }
            return -1;
        }

        public void remove(int key) {
            MapEntry curr = bucket[getHash(key)];
            while (curr != null && curr.next != null) {
                if (curr.next.key == key) {
                    curr.next = curr.next.next;
                    return;
                }
                curr = curr.next;
            }
        }

        private int getHash(int key) {
            return Integer.hashCode(key) % bucket.length;
        }

        class MapEntry {
            int key;
            int val;
            MapEntry next;

            MapEntry(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
