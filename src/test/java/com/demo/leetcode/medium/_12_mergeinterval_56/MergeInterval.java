package com.demo.leetcode.medium._12_mergeinterval_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [56. Merge Intervals - MEDIUM](https://leetcode.com/problems/merge-intervals/)
 *
 * - sort interval
 * - don't add immediately
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=44H3cEC2fFM&ab_channel=NeetCode
 */
public class MergeInterval {

    @Test
    public void test1() {
        int intervals[][] = {{1, 3}, {8, 10}, {15, 18}, {2, 6}};
        int expected[][] = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test2() {
        int intervals[][] = {{1, 3}, {4, 5}, {8, 10}};
        int expected[][] = {{1, 3}, {4, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test3() {
        int intervals[][] = {{1, 3}, {2, 5}, {8, 10}};
        int expected[][] = {{1, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test4() {
        int intervals[][] = {{2, 6}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 6}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test5() {
        int intervals[][] = {{4, 7}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {4, 7}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test6() {
        int intervals[][] = {{9, 12}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {8, 12}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test7() {
        int intervals[][] = {{11, 12}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {8, 10}, {11, 12}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test8() {
        int intervals[][] = {{1, 3}, {4, 8}, {9, 12}, {1, 14}};
        int expected[][] = {{1, 14}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     */
    public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals.length <= 1) {
            return intervals;
        }
        //sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        //start from 2nd interval
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
                //don't add to result yet.
            } else {
                result.add(prev);
                prev = intervals[i];
            }
        }
        result.add(prev);
        return result.toArray(new int[result.size()][]);
    }
}
