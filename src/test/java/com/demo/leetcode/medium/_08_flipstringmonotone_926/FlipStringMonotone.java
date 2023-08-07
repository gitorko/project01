package com.demo.leetcode.medium._08_flipstringmonotone_926;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [926. Flip String to Monotone Increasing - MEDIUM](https://leetcode.com/problems/flip-string-to-monotone-increasing/)
 *
 * https://www.youtube.com/watch?v=tMq9z5k3umQ&ab_channel=NeetCodeIO
 */
public class FlipStringMonotone {

    @Test
    public void test() {
        String s = "00110";
        Assertions.assertEquals(1, minFlipsMonoIncr(s));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int flipCount = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (oneCount == 0) {
                    continue;
                } else {
                    flipCount++;
                }
            } else {
                oneCount++;
            }
            if (flipCount > oneCount) {
                flipCount = oneCount;
            }
        }
        return flipCount;
    }
}
