package com.demo.leetcode.easy._01_canplaceflower_605;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [605. Can Place Flowers - EASY](https://leetcode.com/problems/can-place-flowers/)
 *
 *  - extra array with zero on either side
 *  - without extra array
 *
 * https://www.youtube.com/watch?v=ZGxqqjljpUI&ab_channel=NeetCode
 */
public class CanPlaceFlower {

    @Test
    public void test_middleFree() {
        int flowerbed[] = {1, 0, 0, 0, 1};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 1));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test_middle2Free() {
        int flowerbed[] = {1, 0, 0, 0, 0, 1};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 1));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test_middle3Free() {
        int flowerbed[] = {1, 0, 0, 0, 0, 0, 1};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 2));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 3));
    }

    @Test
    public void test_startFree() {
        int flowerbed[] = {0, 0, 1};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 1));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    @Test
    public void test_endFree() {
        int flowerbed[] = {1, 0, 0};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 1));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 2));
    }

    /**
     * Can place 2 flowers on either end.
     */
    @Test
    public void test_AllFree() {
        int flowerbed[] = {0, 0, 0};
        Assertions.assertTrue(canPlaceFlowers(flowerbed, 2));
        Assertions.assertFalse(canPlaceFlowers(flowerbed, 3));
    }

    /**
     * Without extra memory
     * Time: O(n)
     * Space: O(1)
     * - cases:
     * - [10001] - can place in middle
     * - [001] - can place flower at beginning
     * - [100] - can place flower at end
     * - [000] - can place 2 flower on either end
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                if (n == 0) return true;
                // place  flower
                flowerbed[i] = 1;
            }
        }
        return false;
    }

    /**
     * Creates a new array
     * Time: O(n)
     * Space: O(n)
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (n == 0) return true;
        int newFlowerBed[] = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, newFlowerBed, 1, flowerbed.length);
        for (int i = 1; i < newFlowerBed.length - 1; i++) {
            if (newFlowerBed[i - 1] == 0 && newFlowerBed[i] == 0 && newFlowerBed[i + 1] == 0) {
                n--;
                if (n == 0) return true;
                // place  flower
                newFlowerBed[i] = 1;
            }
        }
        return false;
    }

}
