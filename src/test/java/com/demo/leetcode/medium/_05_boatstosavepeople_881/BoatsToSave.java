package com.demo.leetcode.medium._05_boatstosavepeople_881;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [881. Boats to Save People - MEDIUM](https://leetcode.com/problems/boats-to-save-people/)
 *
 * - sort, two pointer
 *
 * https://www.youtube.com/watch?v=XbaxWuHIWUs&ab_channel=NeetCode
 */
public class BoatsToSave {

    @Test
    public void test() {
        int[] people = {1, 2};
        int limit = 3;
        Assertions.assertEquals(1, numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int remain = limit - people[right];
            right--;
            result++;
            if (left <= right && people[left] <= remain) left++;
        }
        return result;
    }
}
