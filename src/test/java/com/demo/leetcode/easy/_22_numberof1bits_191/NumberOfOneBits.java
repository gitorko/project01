package com.demo.leetcode.easy._22_numberof1bits_191;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [191. Number of 1 Bits - EASY](https://leetcode.com/problems/number-of-1-bits/)
 *
 * - mod and divide
 *
 * https://www.youtube.com/watch?v=5Km3utixwZs&ab_channel=NeetCode
 */
public class NumberOfOneBits {

    @Test
    public void test1() {
        Assertions.assertEquals(3, hammingWeight(00000000000000000000000000001011));
        Assertions.assertEquals(3, hammingWeight2(00000000000000000000000000001011));
    }

    /**
     * Time: O(32)
     */
    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n = n / 2;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        while (n > 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public int hammingWeight3(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                result++;
            }
        }
        return result;
    }
}
