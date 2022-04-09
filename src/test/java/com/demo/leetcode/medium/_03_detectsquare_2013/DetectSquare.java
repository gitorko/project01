package com.demo.leetcode.medium._03_detectsquare_2013;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2013. Detect Squares - MEDIUM](https://leetcode.com/problems/detect-squares/)
 *
 * - map to count duplicate
 * - list to hold points
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=bahebearrDc&ab_channel=NeetCode
 */
public class DetectSquare {

    @Test
    public void test() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        Assertions.assertEquals(1, detectSquares.count(new int[]{11, 10}));
        Assertions.assertEquals(0, detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        Assertions.assertEquals(2, detectSquares.count(new int[]{11, 10}));
    }

    class DetectSquares {
        //as there can be duplicate point
        int[][] pointCountMap = new int[1001][1001];
        List<int[]> points = new ArrayList<>();

        public void add(int[] p) {
            pointCountMap[p[0]][p[1]] += 1;
            points.add(p);
        }

        public int count(int[] p1) {
            int x1 = p1[0];
            int y1 = p1[1];
            int result = 0;
            for (int[] point : points) {
                int x2 = point[0];
                int y2 = point[1];
                if (Math.abs(x1 - x2) == 0 || Math.abs(x1 - x2) != Math.abs(y1 - y2))
                    continue;
                //opposite points
                result += pointCountMap[x1][y2] * pointCountMap[x2][y1];
            }
            return result;
        }
    }
}
