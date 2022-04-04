package com.demo.leetcode.medium._01_carfleet_853;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [853. Car Fleet - MEDIUM](https://leetcode.com/problems/car-fleet/)
 *
 * - reverse sort by reaching time
 *
 * https://www.youtube.com/watch?v=Pr6T-3yB9RM&ab_channel=NeetCode
 */
public class CarFleet {

    @Test
    public void test() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        Assertions.assertEquals(3, carFleet(target, position, speed));
    }

    /**
     * Time: O(n log(n))
     * Space: O(n)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; ++i) {
            //[position, reaching time]
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        //reverse sort
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);

        // the time of the slowest car to reach the target
        double maxTime = 0;
        int result = 0;
        for (Car car : cars) {
            if (car.time > maxTime) {
                maxTime = car.time;
                result++;
            }
        }
        return result;
    }

    class Car {
        public int pos;
        public double time;

        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
