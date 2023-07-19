package com.demo.leetcode.easy._22_reversebits_190;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [190. Reverse Bits - EASY](https://leetcode.com/problems/reverse-bits/)
 *
 * https://www.youtube.com/watch?v=UcoN6UjAI64&ab_channel=NeetCode
 */
public class ReverseBits {

    @Test
    public void test() {
        int n = 43261596;
        Assertions.assertEquals(964176192, reverseBits(n));
    }

    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
}
