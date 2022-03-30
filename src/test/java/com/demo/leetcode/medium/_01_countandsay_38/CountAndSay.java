package com.demo.leetcode.medium._01_countandsay_38;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [38. Count and Say - MEDIUM](https://leetcode.com/problems/count-and-say/)
 *
 * - string builder
 */
public class CountAndSay {

    @Test
    public void test() {
        Assertions.assertEquals("1211", countAndSay(4));
    }

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j - 1) == res.charAt(j)) count++;
                else {
                    sb.append(count);
                    sb.append(res.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(res.charAt(res.length() - 1));

            res = sb.toString();
        }
        return res;
    }
}
