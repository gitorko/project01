package com.demo.leetcode.medium._12_coveredinterval_1288;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1288. Remove Covered Intervals - MEDIUM](https://leetcode.com/problems/remove-covered-intervals/)
 *
 * https://www.youtube.com/watch?v=nhAsMabiVkM&ab_channel=NeetCode
 */
public class CoveredInterval {

    @Test
    public void test() {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        Assertions.assertEquals(2, removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        int result = 0;
        int right = 0;
        //if starting is same, then compare the ending
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                ++result;
                right = interval[1];
            }
        }
        return result;
    }
}
