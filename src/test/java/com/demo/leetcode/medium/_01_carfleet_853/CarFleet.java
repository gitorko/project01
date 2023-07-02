package com.demo.leetcode.medium._01_carfleet_853;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [853. Car Fleet - MEDIUM](https://leetcode.com/problems/car-fleet/)
 *
 * - reaching time
 * - reverse sort by position
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=Pr6T-3yB9RM&ab_channel=NeetCode
 */
public class CarFleet {

    @Test
    public void test1() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        Assertions.assertEquals(3, carFleet(target, position, speed));
    }

    @Test
    public void test2() {
        int target = 12;
        int[] position = {10, 0};
        int[] speed = {2, 2};
        Assertions.assertEquals(2, carFleet(target, position, speed));
    }

    /**
     * Time: O(n*log(n))
     * Space: O(n)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] items = new Pair[position.length];
        for (int i = 0; i < position.length; ++i) {
            //[position, reaching time]
            items[i] = new Pair(position[i], (double) (target - position[i]) / speed[i]);
        }
        //reverse sort
        Arrays.sort(items, (a, b) -> b.pos - a.pos);
        // the time of the slowest car to reach the target
        double maxReachingTime = 0;
        int result = 0;
        for (Pair item : items) {
            if (item.time > maxReachingTime) {
                maxReachingTime = item.time;
                result++;
            }
        }
        return result;
    }

    class Pair {
        public int pos;
        public double time;

        public Pair(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
