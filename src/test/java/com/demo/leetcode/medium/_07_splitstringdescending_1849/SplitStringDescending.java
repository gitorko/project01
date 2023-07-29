package com.demo.leetcode.medium._07_splitstringdescending_1849;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1849. Splitting a String Into Descending Consecutive Values - MEDIUM](https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/)
 *
 * - backtracking
 *
 * https://www.youtube.com/watch?v=eDtMmysldaw&ab_channel=NeetCode
 */
public class SplitStringDescending {

    @Test
    public void test1() {
        String s = "1234";
        Assertions.assertFalse(splitString(s));
    }

    @Test
    public void test2() {
        String s = "3520515049";
        Assertions.assertFalse(splitString(s));
    }

    @Test
    public void test3() {
        String s = "53520515049";
        Assertions.assertTrue(splitString(s));
    }

    @Test
    public void test4() {
        String s = "94650723337775781477";
        Assertions.assertFalse(splitString(s));
    }

    @Test
    public void test5() {
        String s = "050043";
        Assertions.assertTrue(splitString(s));
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    String s;

    public boolean splitString(String s) {
        this.s = s;
        for (int i = 0; i < this.s.length() - 1; i++) {
            BigInteger val = new BigInteger(s.substring(0, i + 1));
            if (dfs(i + 1, val)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int index, BigInteger prev) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index; i < s.length(); i++) {
            BigInteger val = new BigInteger(s.substring(index, i + 1));
            if (val.add(BigInteger.ONE).equals(prev) && dfs(i + 1, val)) {
                return true;
            }
        }
        return false;
    }
}
