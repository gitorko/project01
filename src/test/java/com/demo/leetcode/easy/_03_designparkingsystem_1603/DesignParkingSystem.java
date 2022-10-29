package com.demo.leetcode.easy._03_designparkingsystem_1603;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1603. Design Parking System - EASY](https://leetcode.com/problems/design-parking-system/)
 *
 * https://www.youtube.com/watch?v=d5zCHesOrSk&ab_channel=NeetCodeIO
 */
public class DesignParkingSystem {

    @Test
    public void test() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        Assertions.assertTrue(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        Assertions.assertTrue(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        Assertions.assertFalse(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        Assertions.assertFalse(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. It is already occupied.
    }

    class ParkingSystem {
        int[] count;

        public ParkingSystem(int big, int medium, int small) {
            count = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (count[carType - 1] > 0) {
                count[carType - 1]--;
                return true;
            }
            return false;
        }
    }
}
