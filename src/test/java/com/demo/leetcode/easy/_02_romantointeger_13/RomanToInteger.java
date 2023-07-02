package com.demo.leetcode.easy._02_romantointeger_13;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [13. Roman to Integer - EASY](https://leetcode.com/problems/roman-to-integer/)
 *
 * - subtract if i < i+1 eg: IX
 * - add if i > i + 1 eg: XI
 * - SIMILAR_TO: [12. Integer to Roman - MEDIUM](https://leetcode.com/problems/integer-to-roman/)
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

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        //loop only till length -1 as we compare i + 1
        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            } else {
                result += roman.get(s.charAt(i));
            }
        }
        return result + roman.get(s.charAt(s.length() - 1));
    }
}
