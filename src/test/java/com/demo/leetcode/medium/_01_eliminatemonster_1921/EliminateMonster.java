package com.demo.leetcode.medium._01_eliminatemonster_1921;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1921. Eliminate Maximum Number of Monsters - MEDIUM](https://leetcode.com/problems/eliminate-maximum-number-of-monsters/)
 *
 * - find arrival distance/speed
 * - sort
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=6QQRayzOTD4&ab_channel=NeetCode
 */
public class EliminateMonster {

    @Test
    public void test1() {
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};
        Assertions.assertEquals(3, eliminateMaximum(dist, speed));
    }

    @Test
    public void test2() {
        int[] dist = {3, 2, 4};
        int[] speed = {5, 3, 2};
        Assertions.assertEquals(1, eliminateMaximum(dist, speed));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] minReach = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            minReach[i] = (int) Math.ceil(dist[i] / (float) speed[i]);
        }
        Arrays.sort(minReach);
        int result = 0;
        for (int i = 0; i < minReach.length; i++) {
            if (minReach[i] > i) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }
}
