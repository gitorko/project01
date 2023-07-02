package com.demo.leetcode.medium._01_integertoroman_12;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [12. Integer to Roman - MEDIUM](https://leetcode.com/problems/integer-to-roman/)
 *
 * - divide & mod
 * - SIMILAR_TO: [13. Roman to Integer - EASY](https://leetcode.com/problems/roman-to-integer/)
 *
 * https://www.youtube.com/watch?v=ohBNdSJyLh8&ab_channel=NeetCode
 */
public class IntegerToRoman {

    @Test
    public void test() {
        Assertions.assertEquals("III", intToRoman(3));
        Assertions.assertEquals("IX", intToRoman(9));
    }

    public String intToRoman(int num) {
        Map<String, Integer> roman = new LinkedHashMap<>();
        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("D", 500);
        roman.put("CD", 400);
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : roman.entrySet()) {
            if (num / entry.getValue() != 0) {
                int count = num / entry.getValue();
                sb.append(entry.getKey().repeat(count));
                num = num % entry.getValue();
            }
        }
        return sb.toString();
    }
}
