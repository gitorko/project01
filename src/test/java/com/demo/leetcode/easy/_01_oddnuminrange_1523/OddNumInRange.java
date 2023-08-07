package com.demo.leetcode.easy._01_oddnuminrange_1523;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1523. Count Odd Numbers in an Interval Range - EASY](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/)
 *
 * https://www.youtube.com/watch?v=wrIWye928JQ&ab_channel=NeetCodeIO
 */
public class OddNumInRange {

    @Test
    public void test() {
        int low = 3, high = 7;
        Assertions.assertEquals(3, countOdds(low, high));
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int countOdds(int low, int high) {
        //counting total numbers in range
        int length = high - low + 1;
        if (low % 2 != 0 && high % 2 != 0) {
            //odd number start and end
            return length / 2 + 1;
        } else {
            //even number
            return length / 2;
        }
    }
}
