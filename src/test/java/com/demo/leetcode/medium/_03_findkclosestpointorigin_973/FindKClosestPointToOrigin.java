package com.demo.leetcode.medium._03_findkclosestpointorigin_973;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 973. https://leetcode.com/problems/k-closest-points-to-origin/ |973. K Closest Points to Origin |heap
 *
 * HINT:
 *  - heap
 *  - (a^2 + b^2) = c^2
 *
 *  TYPE: MEDIUM (2/5)
 *
 * https://www.youtube.com/watch?v=rI2EBUEMfTk&ab_channel=NeetCode
 */
public class FindKClosestPointToOrigin {

    @Test
    public void test() {
        int points[][] = {{1, 3}, {-2, 2}}, k = 1;
        int expected[][] = {{-2, 2}};
        Assertions.assertArrayEquals(expected, kClosest(points, k));
    }

    @Test
    public void test2() {
        int points[][] = {{1, 3}, {-2, 2}}, k = 1;
        int expected[][] = {{-2, 2}};
        Assertions.assertArrayEquals(expected, kClosest2(points, k));
    }

    /**
     * Time: O(n*log(k))
     */
    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.toArray(new int[k][2]);
    }

    /**
     * Sorting all points based on c^2 value. (a^2 + b^2 = c^2)
     * Brute force, sort in O(n log(n) and return 0-k
     * Time: O(n log(n))
     */
    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, k);
    }
}
