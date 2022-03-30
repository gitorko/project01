package com.demo.leetcode.medium._03_handofstraights_846;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [846. Hand of Straights - MEDIUM](https://leetcode.com/problems/hand-of-straights/)
 *
 * - Tree Map
 * - SIMILAR_TO: [1296. Divide Array in Sets of K Consecutive Numbers](https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/)
 *
 * https://www.youtube.com/watch?v=amnrMCVd2YI&ab_channel=NeetCode
 */
public class HandOfStraights {

    @Test
    public void test() {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        Assertions.assertTrue(isNStraightHand(hand, groupSize));
    }

    /**
     * Time: O(m * log(m) + mk), where mm = # of different nums
     * Space: O(m)
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int card : hand)
            count.put(card, count.getOrDefault(card, 0) + 1);

        for (int start : count.keySet()) {
            int value = count.get(start);
            if (value > 0)
                for (int i = start; i < start + groupSize; i++) {
                    //decrement
                    count.put(i, count.getOrDefault(i, 0) - value);
                    if (count.get(i) < 0)
                        return false;
                }
        }
        return true;
    }
}
