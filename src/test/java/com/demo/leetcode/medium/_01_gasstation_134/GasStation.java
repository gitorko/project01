package com.demo.leetcode.medium._01_gasstation_134;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [134. Gas Station - MEDIUM](https://leetcode.com/problems/gas-station/)
 *
 * - greedy, total reset to 0
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=lJwbPZGo05A&ab_channel=NeetCode
 */
public class GasStation {

    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Assertions.assertEquals(3, canCompleteCircuit(gas, cost));
    }

    @Test
    public void test2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        Assertions.assertEquals(-1, canCompleteCircuit(gas, cost));
    }

    /**
     * Time: O(n)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        if (totalGas < totalCost) return -1;

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
