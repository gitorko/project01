package com.demo.leetcode.medium._05_boatstosavepeople_881;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Boats to Save People without count per boat - MEDIUM]()
 *
 * - boat can allow any number of people as long as the weight is within limit
 * - sort, two pointer, greedy
 * - PRACTICE: P2
 */
public class BoatsToSaveWithoutLimit {

    @Test
    public void test1() {
        int[] people = {1, 1, 5, 2, 3, 3};
        int limit = 5;
        Assertions.assertEquals(3, numRescueBoats(people, limit));
    }

    @Test
    public void test2() {
        int[] people = {1, 1, 1, 2, 3, 3, 5};
        int limit = 5;
        Assertions.assertEquals(4, numRescueBoats(people, limit));
    }

    @Test
    public void test3() {
        int[] people = {1, 3, 3, 3, 4, 6};
        int limit = 10;
        Assertions.assertEquals(2, numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int left = 0;
        int right = people.length - 1;
        int capacity = 0;
        while (left <= right) {
            capacity = 0;
            while (left <= right && capacity < limit && people[right] <= limit - capacity) {
                capacity += people[right];
                right--;
            }
            while (left <= right && capacity < limit && people[left] <= limit - capacity) {
                capacity += people[left];
                left++;
            }
            result++;
        }
        return result;
    }
}
