package com.demo.leetcode.medium._12_mergeinterval_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [56. Merge Intervals - MEDIUM](https://leetcode.com/problems/merge-intervals/)
 *
 * - merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input
 * - sort interval
 * - add to result and modify reference
 *
 * PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=44H3cEC2fFM&ab_channel=NeetCode
 */
public class MergeInterval {

    @Test
    public void test() {
        int intervals[][] = {{1, 3}, {8, 10}, {15, 18}, {2, 6}};
        int expected[][] = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_noOverLap_beginning() {
        int intervals[][] = {{1, 3}, {4, 5}, {8, 10}};
        int expected[][] = {{1, 3}, {4, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_overLap_beginning() {
        int intervals[][] = {{1, 3}, {2, 5}, {8, 10}};
        int expected[][] = {{1, 5}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_overLap_middle() {
        int intervals[][] = {{2, 6}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 6}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_noOverLap_middle() {
        int intervals[][] = {{4, 7}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {4, 7}, {8, 10}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_overlap_end() {
        int intervals[][] = {{9, 12}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {8, 12}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_noOverlap_end() {
        int intervals[][] = {{11, 12}, {1, 3}, {8, 10}};
        int expected[][] = {{1, 3}, {8, 10}, {11, 12}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    @Test
    public void test_longInterval_end() {
        int intervals[][] = {{1, 3}, {4, 8}, {9, 12}, {1, 14}};
        int expected[][] = {{1, 14}};
        Assertions.assertArrayEquals(expected, merge(intervals));
    }

    /**
     * Time: O(n*log(n)) - as sorting is required
     */
    public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] previousPair = intervals[0];
        //add to result but later modify the reference
        result.add(previousPair);
        for (int i = 1; i < intervals.length; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if (newStart <= previousPair[1]) {
                previousPair[1] = Math.max(newEnd, previousPair[1]);
                //dont add to result yet.
            } else {
                previousPair = intervals[i];
                result.add(previousPair);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
