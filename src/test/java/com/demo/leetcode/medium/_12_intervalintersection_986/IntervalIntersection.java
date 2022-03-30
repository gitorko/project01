package com.demo.leetcode.medium._12_intervalintersection_986;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [986. Interval List Intersections - MEDIUM](https://leetcode.com/problems/interval-list-intersections/)
 *
 * - both lists are sorted
 * - two pointer
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=EsuaXBQh4hs&ab_channel=jayatitiwari
 */
public class IntervalIntersection {

    @Test
    public void test() {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] actual = intervalIntersection(firstList, secondList);
        int[][] expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Time: O(M + N)
     * Space: O(M + N)
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Let's check if firstList[i] intersects secondList[j].
            // lo - the start point of the intersection
            // hi - the end point of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi)
                result.add(new int[]{lo, hi});

            // move pointers forward
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
