package com.demo.leetcode.easy._05_factorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Factorial - EASY](#)
 *
 * - f(n) = n * (n-1) * (n-2) * ..1
 */
public class Factorial {

    @Test
    public void test() {
        Assertions.assertEquals(6, factorial1(3));
        Assertions.assertEquals(6, factorial2(3));
    }

    /**
     * iterative
     */
    public int factorial1(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    /**
     * recursion
     */
    public int factorial2(int n) {
        if (n == 0) return 1;
        return n * factorial2(n - 1);
    }

}

