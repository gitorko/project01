package com.demo.leetcode.medium._12_minmeetingroom_253;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [253. Meeting Rooms II - MEDIUM](https://leetcode.com/problems/meeting-rooms-ii/)
 * https://www.lintcode.com/problem/919/
 *
 * - option1: Use heap
 * - option2: Two array comparison
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=FdzJmTCVyJU&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=tNhiD4SaumY&ab_channel=DEEPTITALESRA
 */
public class MinMeetingRoom2 {

    @Test
    public void test_overlap() {
        int intervals[][] = {{1, 3}, {2, 5}, {3, 8}};
        Assertions.assertEquals(2, minMeetingRoom(intervals));
        Assertions.assertEquals(2, minMeetingRoom2(intervals));
    }

    @Test
    public void test_noOverlap() {
        int intervals[][] = {{1, 3}, {3, 5}, {5, 6}};
        Assertions.assertEquals(1, minMeetingRoom(intervals));
        Assertions.assertEquals(1, minMeetingRoom2(intervals));
    }

    @Test
    public void test_oneRoom() {
        int intervals[][] = {{1, 3}};
        Assertions.assertEquals(1, minMeetingRoom(intervals));
        Assertions.assertEquals(1, minMeetingRoom2(intervals));
    }

    @Test
    public void test_threeRoom() {
        int intervals[][] = {{1, 5}, {1, 7}, {2, 4}};
        Assertions.assertEquals(3, minMeetingRoom(intervals));
        Assertions.assertEquals(3, minMeetingRoom2(intervals));
    }

    /**
     * If you do count-- this case will fail as the first input will make the count negative
     */
    @Test
    public void test_overlapAtEnd_manyAtFirst() {
        int intervals[][] = {{1, 3}, {3, 6}, {6, 9}, {9, 12}, {11, 14}};
        Assertions.assertEquals(2, minMeetingRoom(intervals));
        Assertions.assertEquals(2, minMeetingRoom2(intervals));
    }

    @Test
    public void test_2() {
        int intervals[][] = {{0, 30}, {5, 10}, {15, 20}};
        Assertions.assertEquals(2, minMeetingRoom(intervals));
        Assertions.assertEquals(2, minMeetingRoom2(intervals));
    }

    @Test
    public void test_3() {
        int intervals[][] = {{4, 30}, {10, 28}, {8, 34}, {17, 22}, {18, 22}};
        Assertions.assertEquals(5, minMeetingRoom(intervals));
        Assertions.assertEquals(5, minMeetingRoom2(intervals));
    }

    @Test
    public void test_4() {
        int intervals[][] = {{0, 30}, {5, 10}, {15, 20}, {2, 10}, {35, 40}};
        Assertions.assertEquals(3, minMeetingRoom(intervals));
        Assertions.assertEquals(3, minMeetingRoom2(intervals));
    }


    @Test
    public void test_inputIsList() {
        List<Interval> intervals = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        Assertions.assertEquals(2, minMeetingRoom(convertListToArray(intervals)));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     * With heap
     */
    public int minMeetingRoom(int[][] intervals) {
        //edge case
        if (intervals.length == 0)
            return 0;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //add first interval end time to heap.
        minHeap.add(intervals[0][1]);
        //iterate from 2nd interval
        for (int i = 1; i < intervals.length; i++) {
            //if top of heap (end time) is less than start time of new meeting
            if (minHeap.peek() <= intervals[i][0]) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }


    /**
     * Without heap
     * Time: O(n*log(n))
     * Space: O(n)
     */
    public int minMeetingRoom2(int[][] intervals) {
        int starts[] = new int[intervals.length];
        int ends[] = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int result = 0;
        int rooms = 0;
        int end = 0;
        int start = 0;
        while (start < intervals.length) {
            if (starts[start] < ends[end]) {
                start++;
                rooms++;
            } else {
                end++;
                rooms--;
            }
            result = Math.max(result, rooms);
        }
        return result;
    }

    private int[][] convertListToArray(List<Interval> intervals) {
        int arr[][] = new int[intervals.size()][2];
        int i = 0;
        for (Interval interval : intervals) {
            arr[i][0] = interval.start;
            arr[i][1] = interval.end;
            i++;
        }
        return arr;
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
