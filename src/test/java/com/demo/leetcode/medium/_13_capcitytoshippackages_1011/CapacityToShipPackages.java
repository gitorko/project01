package com.demo.leetcode.medium._13_capcitytoshippackages_1011;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1011. Capacity To Ship Packages Within D Days - MEDIUM](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
 *
 * - binary search
 * - SIMILAR_TO: [875. Koko Eating Bananas - MEDIUM](https://leetcode.com/problems/koko-eating-bananas/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=ER_oLmdc-nw&ab_channel=NeetCodeIO
 */
public class CapacityToShipPackages {

    @Test
    public void test() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        Assertions.assertEquals(15, shipWithinDays(weights, days));
    }

    /**
     * Time: O(n * log(sum(weights))
     * Space: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            if (shipDays(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * For given ship capacity find out how many days
     */
    private int shipDays(int[] weights, int shipCapacity) {
        int days = 1;
        int capacity = 0;
        for (int weight : weights) {
            if (capacity + weight > shipCapacity) {
                days++;
                capacity = weight;
            } else {
                capacity += weight;
            }
        }
        return days;
    }
}
