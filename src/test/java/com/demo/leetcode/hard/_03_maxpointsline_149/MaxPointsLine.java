package com.demo.leetcode.hard._03_maxpointsline_149;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [149. Max Points on a Line - HARD](https://leetcode.com/problems/max-points-on-a-line/description/)
 *
 * - slope: (y2-y1) / (x2-x1)
 * - edge case of vertical line with slope of 0.
 *
 * https://www.youtube.com/watch?v=Bb9lOXUOnFw&ab_channel=NeetCodeIO
 */
public class MaxPointsLine {

    @Test
    public void test1() {
        int points[][] = {{1, 1}, {2, 2}, {3, 3}};
        Assertions.assertEquals(3, maxPoints(points));
    }

    @Test
    public void test2() {
        int points[][] = {{3, 3}, {3, 4}, {3, 5}};
        Assertions.assertEquals(3, maxPoints(points));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int[] p1 : points) {
            //very important to reset map for each point
            Map<Double, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                //if both are same points skip
                if (p1 == p2) {
                    continue;
                }
                double slope = 0;
                if (p2[0] - p1[0] == 0) {
                    //when vertical line
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    //slope: (y2-y1) / (x2-x1)
                    slope = (p2[1] - p1[1]) / (double) (p2[0] - p1[0]);
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
        }
        //+1 because we count the origin point
        return max + 1;
    }
}
