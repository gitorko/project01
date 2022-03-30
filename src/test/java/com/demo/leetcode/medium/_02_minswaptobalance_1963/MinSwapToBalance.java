package com.demo.leetcode.medium._02_minswaptobalance_1963;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1963. Minimum Number of Swaps to Make the String Balanced - MEDIUM](https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/)
 *
 * - +1 and divide by 2
 *
 * https://www.youtube.com/watch?v=3YDBT9ZrfaU&ab_channel=NeetCode
 */
public class MinSwapToBalance {

    @Test
    public void test1() {
        Assertions.assertEquals(1, minSwaps("][]["));
        Assertions.assertEquals(1, minSwaps2("][]["));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, minSwaps("]]][[["));
        Assertions.assertEquals(2, minSwaps2("]]][[["));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(0, minSwaps("[[]][]"));
        Assertions.assertEquals(0, minSwaps2("[[]][]"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     *
     * Generic solution that can handle edge cases as well.
     *  - open and close are not same
     *  - they cant be balanced at all
     */
    public int minSwaps(String s) {
        int openCount = 0;
        int closeCount = 0;
        int openExtra = 0;
        int closeExtra = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                openCount++;
                if (openCount < closeCount) {
                    openExtra++;
                    openCount--;
                } else {
                    openExtra++;
                }
            } else if (s.charAt(i) == ']') {
                closeCount++;
                if (openCount < closeCount) {
                    closeExtra++;
                    closeCount--;
                } else {
                    closeCount--;
                    openCount--;
                    openExtra--;
                }
            }
        }
        return openExtra == closeExtra ? (closeExtra + 1) / 2 : -1;
    }

    public int minSwaps2(String s) {
        int close = 0;
        int maxClose = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                close--;
            } else {
                close++;
            }
            maxClose = Math.max(maxClose, close);
        }
        return (maxClose + 1) / 2;
    }
}
