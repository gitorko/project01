package com.demo.leetcode.easy._01_arrayformofint_989;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [989. Add to Array-Form of Integer - EASY](https://leetcode.com/problems/add-to-array-form-of-integer)
 *
 * - linked list as we need to add to first
 *
 * https://www.youtube.com/watch?v=eBTZQt1TWfk&ab_channel=NeetCodeIO
 */
public class ArrayFormInteger {

    @Test
    public void test() {
        int[] num = {1, 2, 0, 0};
        int k = 34;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(expected, addToArrayForm(num, k));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; i--) {
            result.addFirst((num[i] + k) % 10);
            //carry gets added to k so no need track separately
            k = (num[i] + k) / 10;
        }
        while (k > 0) {
            result.addFirst(k % 10);
            k /= 10;
        }
        return result;
    }
}
