package com.demo.leetcode.medium._12_checkintervaloverlap_252;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [252. Meeting Rooms - MEDIUM](https://leetcode.com/problems/meeting-rooms/)
 *
 * - https://www.lintcode.com/problem/920
 * - Check if intervals overlap
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=PaJxqZVPhbg&ab_channel=NeetCode
 */
public class CanAttendMeeting {

    @Test
    public void test_overlap() {
        int intervals[][] = {{1, 3}, {8, 10}, {15, 18}, {2, 6}};
        Assertions.assertTrue(checkOverlap(intervals));
    }

    @Test
    public void test_noOverlap() {
        int intervals[][] = {{1, 3}, {8, 10}, {15, 18}};
        Assertions.assertFalse(checkOverlap(intervals));
    }

    @Test
    public void test_2() {
        int intervals[][] = {{0, 30}, {5, 10}, {15, 20}};
        Assertions.assertTrue(checkOverlap(intervals));
    }

    @Test
    public void test_emptyInput() {
        int intervals[][] = {};
        Assertions.assertFalse(checkOverlap(intervals));
    }

    /**
     * Time: O(n log(n))
     */
    public boolean checkOverlap(int intervals[][]) {
        if (intervals.length == 0) {
            return false;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int previousEnd = intervals[0][1];
        //start from 2nd interval
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //No overlap
            if (start >= previousEnd) {
                previousEnd = end;
            } else {
                return true;
            }
        }
        return false;
    }

}
