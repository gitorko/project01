package com.demo.leetcode.hard._04_minintervalquery_1851;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1851. Minimum Interval to Include Each Query - HARD](https://leetcode.com/problems/minimum-interval-to-include-each-query/)
 *
 * - min heap
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=5hQ5WWW5awQ&ab_channel=NeetCode
 */
public class MinIntervalQuery {

    @Test
    public void test1() {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        int[] expected = {3, 3, 1, 4};
        Assertions.assertArrayEquals(expected, minInterval(intervals, queries));
    }

    @Test
    public void test2() {
        int[][] intervals = {{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] queries = {2, 19, 5, 22};
        int[] expected = {2, -1, 4, 6};
        Assertions.assertArrayEquals(expected, minInterval(intervals, queries));
    }

    @Test
    public void test3() {
        int[][] intervals = {{1, 9}, {1, 6}, {4, 5}, {5, 8}, {8, 10},};
        int[] queries = {7, 9, 3, 9, 3};
        int[] expected = {4, 3, 6, 3, 6};
        Assertions.assertArrayEquals(expected, minInterval(intervals, queries));
    }

    @Test
    public void test4() {
        int[][] intervals = {{1, 9}, {2, 5}};
        int[] queries = {6};
        int[] expected = {9};
        Assertions.assertArrayEquals(expected, minInterval(intervals, queries));
    }

    /**
     * Time: O(n*log(n) + q*log(q))
     * Space: O(n + q)
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        //[query, length]
        Map<Integer, Integer> result = new HashMap<>();
        //[length, rightVal]
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int[] queriesCopy = Arrays.copyOf(queries, queries.length);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queriesCopy);
        int index = 0;
        for (int query : queriesCopy) {
            //add interval that start before query
            while (index < intervals.length && intervals[index][0] <= query) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                minHeap.add(new int[]{right - left + 1, right});
                index++;
            }
            //remove interval that have ended before query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                int length = minHeap.peek()[0];
                //add to result
                result.put(query, length);
            } else {
                result.put(query, -1);
            }

        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = result.get(queries[i]);
        }
        return queries;
    }
}
