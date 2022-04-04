package com.demo.leetcode.medium._01_integertoroman_12;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [12. Integer to Roman - MEDIUM](https://leetcode.com/problems/integer-to-roman/)
 *
 * - divide & mod
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
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (num / entry.getValue() != 0) {
                int count = num / entry.getValue();
                sb.append(entry.getKey().repeat(count));
                num = num % entry.getValue();
            }
        }
        return sb.toString();
    }
}
