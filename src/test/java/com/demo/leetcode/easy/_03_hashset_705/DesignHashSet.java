package com.demo.leetcode.easy._03_hashset_705;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [705. Design HashSet - EASY](https://leetcode.com/problems/design-hashset/)
 *
 * https://www.youtube.com/watch?v=VymjPQUXjL8&ab_channel=NeetCodeIO
 */
public class DesignHashSet {

    @Test
    public void test() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        Assertions.assertTrue(myHashSet.contains(1)); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        Assertions.assertTrue(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        Assertions.assertFalse(myHashSet.contains(2)); // return False, (already removed)
    }

    class MyHashSet {
        List<Integer>[] container = null;
        int capacity = 1000;
        double loadFactor = 0.75;
        int count = 0;

        /** Initialize your data structure here. */
        public MyHashSet() {
            container = new LinkedList[capacity];
        }

        public void add(int key) {
            //check if already exists
            if (contains(key)) {
                return;
            }
            //check load factor
            if (loadFactor * capacity == count) {
                count = 0;
                //rehash
                capacity *= 2;
                List<Integer>[] oldC = container;
                container = new LinkedList[capacity];
                for (int i = 0; i < oldC.length; i++) {
                    List<Integer> list = oldC[i];
                    if (list != null) {
                        for (int entry : list) {
                            this.add(entry);
                        }
                    }
                }
            }
            int hash = key % capacity;
            if (container[hash] == null) {
                container[hash] = new LinkedList<>();
            }
            container[hash].add(key);
            count++;
        }

        public void remove(int key) {
            int hash = key % capacity;
            List<Integer> list = container[hash];
            if (list != null) {
                Iterator<Integer> itr = list.iterator();
                while (itr.hasNext())
                    if (itr.next() == key) {
                        itr.remove();
                        count--;
                        break;
                    }
            }
        }

        public boolean contains(int key) {
            int hash = key % capacity;
            List<Integer> list = container[hash];
            if (list != null) {
                for (int entry : list) {
                    if (entry == key) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
