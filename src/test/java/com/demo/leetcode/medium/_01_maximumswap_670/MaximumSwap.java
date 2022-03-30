package com.demo.leetcode.medium._01_maximumswap_670;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [670. Maximum Swap - MEDIUM](https://leetcode.com/problems/maximum-swap/)
 *
 * - digit position, check if greater than i
 *
 * PRACTICE
 */
public class MaximumSwap {

    @Test
    public void test1() {
        Assertions.assertEquals(7236, maximumSwap(2736));
        Assertions.assertEquals(7236, maximumSwap2(2736));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(9973, maximumSwap(9937));
        Assertions.assertEquals(9973, maximumSwap2(9937));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(9913, maximumSwap(1993));
        Assertions.assertEquals(9913, maximumSwap2(1993));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int maximumSwap(int num) {
        char[] numbers = String.valueOf(num).toCharArray();
        int[] indexMap = new int[10];

        for (int i = 0; i < numbers.length; i++)
            indexMap[numbers[i] - '0'] = i;

        // O(n) * O(1)
        for (int i = 0; i < numbers.length; i++)
            for (int d = 9; d > numbers[i] - '0'; d--)
                if (indexMap[d] > i) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[indexMap[d]];
                    numbers[indexMap[d]] = (char) tmp;
                    return Integer.parseInt(new String(numbers));
                }
        return num;
    }

    public int maximumSwap2(int num) {
        char[] numbers = String.valueOf(num).toCharArray();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 9) continue;
            int max = -1;
            int pos = -1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[i]) {
                    if (numbers[j] >= max) {
                        pos = j;
                        max = numbers[j];
                    }
                }
            }
            if (max == -1) continue;
            int tmp = numbers[i];
            numbers[i] = numbers[pos];
            numbers[pos] = (char) tmp;
            return Integer.parseInt(new String(numbers));
        }
        return num;
    }
}
