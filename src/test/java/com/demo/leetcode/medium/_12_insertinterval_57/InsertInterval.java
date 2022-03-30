package com.demo.leetcode.medium._12_insertinterval_57;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [57. Insert Interval - MEDIUM](https://leetcode.com/problems/insert-interval/)
 *
 * - interval 3 cases
 * - intervals are sorted.
 * - multiple overlap
 *
 * https://www.youtube.com/watch?v=A8NUOmlwOlM&ab_channel=NeetCode
 */
public class InsertInterval {

    @Test
    public void test_noOverLap_beginning() {
        int intervals[][] = {{4, 5}, {8, 10}};
        int newInterval[] = {1, 3};
        int expected[][] = {{1, 3}, {4, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_overLap_beginning() {
        int intervals[][] = {{2, 5}, {8, 10}};
        int newInterval[] = {1, 3};
        int expected[][] = {{1, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_overLap_middle() {
        int intervals[][] = {{1, 3}, {8, 10}};
        int newInterval[] = {2, 6};
        int expected[][] = {{1, 6}, {8, 10}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_noOverLap_middle() {
        int intervals[][] = {{1, 3}, {8, 10}};
        int newInterval[] = {4, 7};
        int expected[][] = {{1, 3}, {4, 7}, {8, 10}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_overlap_end() {
        int intervals[][] = {{1, 3}, {8, 10}};
        int newInterval[] = {9, 12};
        int expected[][] = {{1, 3}, {8, 12}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_noOverlap_end() {
        int intervals[][] = {{1, 3}, {8, 10}};
        int newInterval[] = {11, 12};
        int expected[][] = {{1, 3}, {8, 10}, {11, 12}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    @Test
    public void test_longInterval_end() {
        int intervals[][] = {{1, 3}, {4, 8}, {9, 12}};
        int newInterval[] = {1, 14};
        int expected[][] = {{1, 14}};
        Assertions.assertArrayEquals(expected, insertInterval(intervals, newInterval));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[][] insertInterval(int intervals[][], int newInterval[]) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            //end value of new pair is less than start
            if (newInterval[1] < start) {
                //no overlap, before interval
                result.add(newInterval);
                //add remaining and return
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            } else if (newInterval[0] > end) {
                //no overlap, after interval
                result.add(intervals[i]);
            } else {
                //overlap case
                int min = Math.min(newInterval[0], intervals[i][0]);
                int max = Math.max(newInterval[1], intervals[i][1]);
                newInterval = new int[]{min, max};
                //dont add immediately to result
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
