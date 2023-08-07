package com.demo.leetcode.medium._05_boatstosavepeople_881;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [881. Boats to Save People - MEDIUM](https://leetcode.com/problems/boats-to-save-people/)
 *
 * - sort, two pointer, greedy
 * - PRACTICE: P2
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

    /**
     * Time: O(n*log(n))
     * Space: O(1)
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int remain = limit - people[right];
            right--;
            result++;
            if (left <= right && people[left] <= remain) {
                left++;
            }
        }
        return result;
    }
}
