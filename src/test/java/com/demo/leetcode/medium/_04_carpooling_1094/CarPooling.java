package com.demo.leetcode.medium._04_carpooling_1094;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1094. Car Pooling - MEDIUM](https://leetcode.com/problems/car-pooling/)
 *
 * - sort, heap
 * - SIMILAR_TO: [253. Meeting Rooms II - MEDIUM](https://leetcode.com/problems/meeting-rooms-ii/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=08sn_w4LWEE&ab_channel=NeetCode
 */
public class CarPooling {

    @Test
    public void test1() {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        Assertions.assertFalse(carPooling(trips, capacity));
        Assertions.assertFalse(carPooling2(trips, capacity));
    }

    @Test
    public void test2() {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        Assertions.assertTrue(carPooling(trips, capacity));
        Assertions.assertTrue(carPooling2(trips, capacity));
    }

    @Test
    public void test3() {
        int[][] trips = {{4, 3, 4}, {3, 2, 4}, {1, 8, 9}, {7, 2, 5}};
        int capacity = 14;
        Assertions.assertTrue(carPooling(trips, capacity));
        Assertions.assertTrue(carPooling2(trips, capacity));
    }

    @Test
    public void test4() {
        int[][] trips = {{10, 5, 7}, {10, 3, 4}, {7, 1, 8}, {6, 3, 4}};
        int capacity = 24;
        Assertions.assertTrue(carPooling(trips, capacity));
        Assertions.assertTrue(carPooling2(trips, capacity));
    }

    @Test
    public void test5() {
        int[][] trips = {{9, 0, 1}, {3, 3, 7}};
        int capacity = 4;
        Assertions.assertFalse(carPooling(trips, capacity));
        Assertions.assertFalse(carPooling2(trips, capacity));
    }

    @Test
    public void test6() {
        int[][] trips = {{2, 1, 3}, {1, 2, 3}, {3, 3, 7}};
        int capacity = 4;
        Assertions.assertTrue(carPooling(trips, capacity));
        Assertions.assertTrue(carPooling2(trips, capacity));
    }

    /**
     * Time: O(n log(n))
     * Space: O(n)
     */
    public boolean carPooling(int[][] trips, int capacity) {
        //[person count, start, end]
        int passenger = 0;
        // Sort by ascending starting point
        Arrays.sort(trips, (i1, i2) -> i1[1] - i2[1]);
        //[person count, end]
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        queue.add(new int[]{trips[0][0], trips[0][2]});
        passenger = trips[0][0];
        if (passenger > capacity) {
            return false;
        }
        //iterate from 2nd trip
        for (int i = 1; i < trips.length; i++) {
            //if top of heap (end time) is less than start time of new trip
            while (!queue.isEmpty() && queue.peek()[1] <= trips[i][1]) {
                int[] item = queue.remove();
                passenger = passenger - item[0];
            }
            passenger = passenger + trips[i][0];
            queue.add(new int[]{trips[i][0], trips[i][2]});
            if (passenger > capacity) {
                return false;
            }
        }
        return passenger <= capacity;
    }

    /**
     * Since the passengers are only 1000
     * Time: O(n)
     * Space: O(n)
     */
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] passenger = new int[10001];
        for (int[] t : trips) {
            passenger[t[1]] += t[0];
            passenger[t[2]] -= t[0];
        }

        int currPassenger = 0;
        for (int i = 0; i < 1001; i++) {
            currPassenger += passenger[i];
            if (currPassenger > capacity)
                return false;
        }
        return true;
    }
}
