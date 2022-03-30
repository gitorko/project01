package com.demo.leetcode.easy._01_replaceelementgreatest_1299;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1299. Replace Elements with Greatest Element on Right Side - EASY](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)
 *
 * - start from reverse
 *
 * https://www.youtube.com/watch?v=ZHjKhUjcsaU&ab_channel=NeetCode
 */
public class ReplaceElementGreatestElement {

    @Test
    public void test() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] expected = {18, 6, 6, 6, 1, -1};
        Assertions.assertArrayEquals(expected, replaceElements(arr));
    }

    public int[] replaceElements(int[] arr) {
        int rightMax = -1, a;
        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(rightMax, arr[i]);
            arr[i] = rightMax;
            rightMax = newMax;
        }
        return arr;
    }

}
