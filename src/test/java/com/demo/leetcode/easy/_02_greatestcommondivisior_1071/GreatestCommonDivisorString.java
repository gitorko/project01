package com.demo.leetcode.easy._02_greatestcommondivisior_1071;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1071. Greatest Common Divisor of Strings - EASY](https://leetcode.com/problems/greatest-common-divisor-of-strings/)
 *
 * https://www.youtube.com/watch?v=i5I_wrbUdzM&ab_channel=NeetCodeIO
 */
public class GreatestCommonDivisorString {

    @Test
    public void test1() {
        String str1 = "ABCABC", str2 = "ABC";
        Assertions.assertEquals("ABC", gcdOfStrings(str1, str2));
    }

    @Test
    public void test2() {
        String str1 = "ABABAB", str2 = "ABAB";
        Assertions.assertEquals("AB", gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdVal = gcd(str1.length(), str2.length());
        return str2.substring(0, gcdVal);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
