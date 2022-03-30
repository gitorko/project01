package com.demo.leetcode.easy._01_assigncookie_455;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [455. Assign Cookies - EASY](https://leetcode.com/problems/assign-cookies)
 *
 * - Sort both arrays.
 */
public class AssignCookie {

    @Test
    public void test() {
        int cookies[] = {1, 1};
        int kidGreed[] = {1, 2, 3};
        Assertions.assertEquals(1, findContentChildren(kidGreed, cookies));

        int cookies2[] = {1, 2, 3};
        int kidGreed2[] = {1, 2};
        Assertions.assertEquals(2, findContentChildren(kidGreed2, cookies2));
    }

    public int findContentChildren(int[] kidGreed, int[] cookies) {
        Arrays.sort(kidGreed);
        Arrays.sort(cookies);
        int i = 0;
        for (int j = 0; i < kidGreed.length && j < cookies.length; j++) {
            if (kidGreed[i] <= cookies[j])
                i++;
        }
        return i;
    }
}
