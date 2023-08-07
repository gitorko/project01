package com.demo.leetcode.hard._04_maxperformanceteam_1383;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1383. Maximum Performance of a Team - HARD](https://leetcode.com/problems/maximum-performance-of-a-team/)
 *
 * - heap
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Y7UTvogADH0&ab_channel=NeetCode
 */
public class MaxPerformanceTeam {

    @Test
    public void test() {
        int n = 6;
        int speed[] = {2, 10, 3, 1, 5, 8};
        int efficiency[] = {5, 4, 3, 9, 7, 2};
        int k = 2;
        Assertions.assertEquals(60, maxPerformance(n, speed, efficiency, k));
    }

    /**
     * Time: O(n * log(n))
     * Space: O(k)
     */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) (1e9 + 7);
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{efficiency[i], speed[i]};
        }
        //Sort in descending order of efficiency
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        //[speed]
        Queue<Integer> minHeap = new PriorityQueue<>();
        long totalSpeed = 0;
        long result = 0;
        for (int[] pair : pairs) {
            int curSpeed = pair[1];
            int currEfficiency = pair[0];
            minHeap.add(curSpeed);
            if (minHeap.size() > k) {
                totalSpeed = totalSpeed - minHeap.poll();
            }
            totalSpeed += curSpeed;
            result = Math.max(result, totalSpeed * currEfficiency);
        }
        return (int) (result % mod);
    }
}
