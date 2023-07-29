package com.demo.leetcode.medium._03_findkclosestpointorigin_973;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [973. K Closest Points to Origin - MEDIUM](https://leetcode.com/problems/k-closest-points-to-origin/)
 *
 *  - heap
 *
 * https://www.youtube.com/watch?v=rI2EBUEMfTk&ab_channel=NeetCode
 */
public class FindKClosestPointToOrigin {

    @Test
    public void test() {
        int points[][] = {{1, 3}, {-2, 2}}, k = 1;
        int expected[][] = {{-2, 2}};
        Assertions.assertArrayEquals(expected, kClosest(points, k));
        Assertions.assertArrayEquals(expected, kClosest2(points, k));
    }

    /**
     * Time: O(n*log(k))
     */
    public int[][] kClosest(int[][] points, int k) {
        //max heap
        //(a^2 + b^2) = c^2
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) {
                //max values pop out
                heap.poll();
            }
        }
        return heap.toArray(new int[k][2]);
    }

    /**
     * Sorting all points in ascending order based on c^2 value. (a^2 + b^2 = c^2)
     * Time: O(n*log(n))
     */
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
}
