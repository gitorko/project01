package com.demo.leetcode.easy._03_happynumber_202;

import java.util.HashSet;
import java.util.Set;

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
    public void test1() {
        Assertions.assertTrue(isHappy(19));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isHappy(2));
    }

    Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        int sum = 0;
        while (n != 0) {
            int val = n % 10;
            sum += val * val;
            n = n / 10;
        }
        if (seen.contains(sum)) {
            return false;
        }
        seen.add(sum);
        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }
}
