package com.demo.leetcode.medium._15_dailytemperature_739;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [739. Daily Temperatures - MEDIUM](https://leetcode.com/problems/daily-temperatures/)
 *
 * - monotonic stack
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=cTBiBSnjO3c&ab_channel=NeetCode
 */
public class DailyTemperature {

    @Test
    public void test() {
        int temperatures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        int expected[] = {1, 1, 4, 2, 1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, dailyTemperatures(temperatures));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }
}
