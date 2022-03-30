package com.demo.leetcode.easy._03_happynumber_202;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [202. Happy Number - EASY](https://leetcode.com/problems/happy-number/)
 *
 * - set, more optimized solution find loop in link list
 *
 *  https://www.youtube.com/watch?v=ljz85bxOYJ0&ab_channel=NeetCode
 */
public class HappyNumber {

    @Test
    public void test() {
        Assertions.assertTrue(isHappy(19));
        Assertions.assertFalse(isHappy(2));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = computeSumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * to get last digit mod
     * to remove first digit divide
     */
    private int computeSumOfSquares(int n) {
        int result = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            result += lastDigit * lastDigit;
            n /= 10;
        }
        return result;
    }
}
