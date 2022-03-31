package com.demo.leetcode.medium._01_pairinterchangerectangle_2001;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2001. Number of Pairs of Interchangeable Rectangles - MEDIUM](https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/)
 *
 * - n!/(n-k)!k!
 * - n * (n - 1) / 2
 * - gcd
 *
 * https://www.youtube.com/watch?v=lEQ8ZlLOuyQ&ab_channel=NeetCode
 */
public class PairInterchangeRectangle {

    @Test
    public void test() {
        int[][] rectangles = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        Assertions.assertEquals(6, interchangeableRectangles(rectangles));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        Map<Double, Integer> countMap = new HashMap<>();
        for (int[] r : rectangles) {
            double key = (double) r[0] / r[1];
            countMap.put(key, countMap.getOrDefault(key, 0) +1);
        }

        for (int value : countMap.values()) {
            result += (long) value * (value - 1) / 2;
        }
        return result;
    }
}
