package com.demo.leetcode.medium._03_dividearraykset_1296;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1296. Divide Array in Sets of K Consecutive Numbers - MEDIUM](https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/)
 *
 * - Tree Map
 * - SIMILAR_TO: [846. Hand of Straights - MEDIUM](https://leetcode.com/problems/hand-of-straights/)
 *
 * Similar to: 846. https://leetcode.com/problems/hand-of-straights/
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=amnrMCVd2YI&ab_channel=NeetCode
 */
public class DivideArrayKSet {

    @Test
    public void test1() {
        int[] hand = {1, 2, 3, 3, 4, 4, 5, 6};
        int groupSize = 4;
        Assertions.assertTrue(isPossibleDivide(hand, groupSize));
    }

    @Test
    public void test2() {
        int[] hand = {3, 3, 2, 2, 1, 1};
        int groupSize = 3;
        Assertions.assertTrue(isPossibleDivide(hand, groupSize));
    }

    /**
     * Time: O(MlogM + N), m is the number of different cards
     * Space: O(m)
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        for (int start : count.keySet()) {
            int value = count.get(start);
            if (value > 0)
                for (int i = start; i < start + k; i++) {
                    count.put(i, count.getOrDefault(i, 0) - value);
                    if (count.get(i) < 0)
                        return false;
                }
        }
        return true;
    }
}
