package com.demo.leetcode.easy._01_addbinary_67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [67. Add Binary - EASY](https://leetcode.com/problems/add-binary/)
 *
 * - reverse, carry, mod by 2
 * - string builder
 * - SIMILAR_TO: [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
 *
 * https://www.youtube.com/watch?v=keuWJ47xG8g&ab_channel=NeetCode
 */
public class AddBinary {

    @Test
    public void test() {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("110", addBinary("11", "11"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }

    /**
     * Time: O(max(∣a∣,∣b∣))
     * Space: O(max(∣a∣,∣b∣))
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
