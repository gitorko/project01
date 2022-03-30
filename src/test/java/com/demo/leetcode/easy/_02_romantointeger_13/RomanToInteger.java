package com.demo.leetcode.easy._02_romantointeger_13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [13. Roman to Integer - EASY](https://leetcode.com/problems/roman-to-integer/)
 *
 * - subtract if i < i+1 eg: IX
 *
 * https://www.youtube.com/watch?v=3jdxYj3DD98&ab_channel=NeetCode
 */
public class RomanToInteger {

    @Test
    public void test() {
        Assertions.assertEquals(9, romanToInt("IX"));
        Assertions.assertEquals(3, romanToInt("III"));
        Assertions.assertEquals(58, romanToInt("LVIII"));
        Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        int[] roman = new int[128];
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        for (int i = 0; i < s.length() - 1; i++)
            if (roman[s.charAt(i)] < roman[s.charAt(i + 1)])
                result -= roman[s.charAt(i)];
            else
                result += roman[s.charAt(i)];

        return result + roman[s.charAt(s.length() - 1)];
    }
}


