package com.demo.leetcode.hard._03_maxpointsline_149;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [149. Max Points on a Line - HARD](https://leetcode.com/problems/max-points-on-a-line/description/)
 *
 * https://www.youtube.com/watch?v=Bb9lOXUOnFw&ab_channel=NeetCodeIO
 */
public class MaxPointsLine {

    @Test
    public void test() {
        int points[][] = {{1, 1}, {2, 2}, {3, 3}};
        Assertions.assertEquals(3, maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int max = 0;
        for (int[] x : points) {
            Map<Double, Integer> map = new HashMap<>();
            for (int[] y : points) {
                if (x == y) {
                    continue;
                }
                double slope = 0;
                if (y[0] - x[0] == 0) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (y[1] - x[1]) / (double) (y[0] - x[0]);
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
        }
        return max + 1;
    }
}
