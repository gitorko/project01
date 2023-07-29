package com.demo.leetcode.easy._01_replaceelementgreatest_1299;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1299. Replace Elements with Greatest Element on Right Side - EASY](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)
 *
 * - start from reverse
 * - important to ask and confirm if array has positive integers
 * - PRACTICE: P2
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
        int rightMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(temp, rightMax);
        }
        return arr;
    }

}
