package com.demo.leetcode.medium._02_zigzag_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [6. Zigzag Conversion - MEDIUM](https://leetcode.com/problems/zigzag-conversion/)
 *
 * https://www.youtube.com/watch?v=Q2Tw6gcVEwc&ab_channel=NeetCode
 */
public class ZigZag {

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Assertions.assertEquals("PAHNAPLSIIGYIR", convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        int incr = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            if (index == 0) {
                incr = 1;
            }
            if (index == numRows - 1) {
                incr = -1;
            }
            index += incr;
        }
        String result = "";
        for (int i = 0; i < sb.length; i++) {
            result += sb[i];
        }
        return result.toString();
    }
}
