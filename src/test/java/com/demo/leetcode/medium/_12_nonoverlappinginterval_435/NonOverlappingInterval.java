package com.demo.leetcode.medium._12_nonoverlappinginterval_435;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [435. Non-overlapping Intervals - MEDIUM](https://leetcode.com/problems/non-overlapping-intervals/)
 *
 * - sort by starting point
 * - take the min of the end value
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=nONCGxWoUfM&ab_channel=NeetCode
 */
public class NonOverlappingInterval {

    @Test
    public void test() {
        int intervals[][] = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assertions.assertEquals(1, eraseOverlapIntervals(intervals));
    }

    @Test
    public void test_twoSmall_oneBig() {
        int intervals[][] = {{1, 2}, {3, 5}, {1, 7}};
        Assertions.assertEquals(1, eraseOverlapIntervals(intervals));
    }

    @Test
    public void test_noOverLap() {
        int intervals[][] = {{1, 2}, {3, 5}, {6, 8}};
        Assertions.assertEquals(0, eraseOverlapIntervals(intervals));
    }

    @Test
    public void test_overLap1() {
        int intervals[][] = {{1, 7}, {3, 5}, {6, 10}};
        Assertions.assertEquals(1, eraseOverlapIntervals(intervals));
    }

    @Test
    public void test_overLap2() {
        int intervals[][] = {{1, 7}, {3, 9}, {8, 12}};
        Assertions.assertEquals(1, eraseOverlapIntervals(intervals));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(1)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //edge case
        if (intervals.length == 0) {
            return 0;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int result = 0;
        int previousEnd = intervals[0][1];
        //start from 2nd interval
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //No overlap
            if (start >= previousEnd) {
                previousEnd = end;
            } else {
                result++;
                previousEnd = Math.min(previousEnd, end);
            }
        }
        return result;
    }
}
