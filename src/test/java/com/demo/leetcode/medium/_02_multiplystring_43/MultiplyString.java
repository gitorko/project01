package com.demo.leetcode.medium._02_multiplystring_43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [43. Multiply Strings - MEDIUM](https://leetcode.com/problems/multiply-strings/)
 *
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=1vZswirL8Y8&ab_channel=NeetCode
 */
public class MultiplyString {

    @Test
    public void test1() {
        String num1 = "123", num2 = "456";
        Assertions.assertEquals("56088", multiply(num1, num2));
    }

    @Test
    public void test2() {
        String num1 = "2", num2 = "3";
        Assertions.assertEquals("6", multiply(num1, num2));
    }

    /**
     * Time: O(m * n)
     * Space: O(m + n)
     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            //dont append leading zero: eg 2*3=06
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
