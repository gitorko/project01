package com.demo.leetcode.hard._04_maxperformanceteam_1383;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1383. Maximum Performance of a Team - HARD](https://leetcode.com/problems/maximum-performance-of-a-team/)
 *
 * - heap
 *
 * PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=Y7UTvogADH0
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
        int[][] ord = new int[n][2];
        for (int i = 0; i < n; i++) {
            ord[i] = new int[]{efficiency[i], speed[i]};
        }
        //Sort in descending order of efficiency
        Arrays.sort(ord, (a, b) -> Integer.compare(b[0], a[0]));
        //Stores the speed in min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long totalSpeed = 0;
        long best = 0;
        for (int[] pair : ord) {
            int spd = pair[1];
            pq.add(spd);
            if (pq.size() <= k) {
                totalSpeed += spd;
            } else {
                totalSpeed += spd - pq.poll();
            }
            best = Math.max(best, totalSpeed * pair[0]);
        }
        return (int) (best % 1000000007);
    }
}
