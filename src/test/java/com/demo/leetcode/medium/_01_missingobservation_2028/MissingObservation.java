package com.demo.leetcode.medium._01_missingobservation_2028;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [2028. Find Missing Observations - MEDIUM](https://leetcode.com/problems/find-missing-observations/)
 *
 * https://www.youtube.com/watch?v=86yKkaNi3sU&ab_channel=NeetCode
 */
public class MissingObservation {

    @Test
    public void test() {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4, n = 2;
        int[] expected = {6, 6};
        Assertions.assertArrayEquals(expected, missingRolls(rolls, mean, n));
    }

    /**
     * Time: O(nTotal)
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int curSum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int nTotal = mean * (n + m) - curSum;
        if (nTotal < n || nTotal > 6 * n) {
            return new int[]{};
        }
        int part = nTotal / n;
        if (part == 0) {
            return new int[]{};
        }
        int remain = nTotal % n;
        Arrays.fill(result, part);
        for (int i = 0; i < remain; i++) {
            result[i]++;
            if (result[i] > 6) {
                return new int[]{};
            }
        }
        return result;
    }
}
