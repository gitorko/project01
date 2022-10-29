package com.demo.leetcode.medium._03_insertdeletegetrandom_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [380. Insert Delete GetRandom - MEDIUM](https://leetcode.com/problems/insert-delete-getrandom-o1/)
 *
 * - map + list
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=j4KwhBziOpg&ab_channel=NeetCode
 */
public class RandomSet {

    @Test
    public void test() {
        RandomizedSet randomizedSet = new RandomizedSet();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        Assertions.assertTrue(randomizedSet.insert(1));
        // Returns false as 2 does not exist in the set.
        Assertions.assertFalse(randomizedSet.remove(2));
        // Inserts 2 to the set, returns true. Set now contains [1,2].
        Assertions.assertTrue(randomizedSet.insert(2));
        // getRandom() should return either 1 or 2 randomly.
        randomizedSet.getRandom();
        // Removes 1 from the set, returns true. Set now contains [2].
        Assertions.assertTrue(randomizedSet.remove(1));
        // 2 was already in the set, so return false.
        Assertions.assertFalse(randomizedSet.insert(2));
        // Since 2 is the only number in the set, getRandom() will always return 2.
        Assertions.assertEquals(2, randomizedSet.getRandom());
    }

    class RandomizedSet {

        // [value, index of value in list]
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> valList = new ArrayList<>();
        Random rand = new Random();

        public boolean insert(int val) {
            if (indexMap.containsKey(val)) {
                return false;
            }
            indexMap.put(val, valList.size());
            valList.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }
            int index = indexMap.get(val);
            indexMap.put(getLastElement(), index);
            indexMap.remove(val);
            valList.set(index, getLastElement());
            valList.remove(valList.size() - 1);
            return true;
        }

        public int getRandom() {
            int index = rand.nextInt(valList.size());
            return valList.get(index);
        }

        private int getLastElement() {
            return valList.get(valList.size() - 1);
        }
    }
}
