package com.demo.leetcode.medium._18_largestnumber_179;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [179. Largest Number - MEDIUM](https://leetcode.com/problems/largest-number/)
 *
 * - edge case of 00
 * - string compare s1+s2 vs s2+s1
 * - sort
 *
 * https://www.youtube.com/watch?v=WDx6Y4i4xJ8&ab_channel=NeetCode
 */
public class LargestNumber {

    @Test
    public void test1() {
        int[] nums = {10, 2};
        Assertions.assertEquals("210", largestNumber(nums));
    }

    @Test
    public void test2() {
        int[] nums = {10, 02};
        Assertions.assertEquals("210", largestNumber(nums));
    }

    @Test
    public void test3() {
        int[] nums = {10, 0};
        Assertions.assertEquals("100", largestNumber(nums));
    }

    @Test
    public void test4() {
        int[] nums = {0, 0};
        Assertions.assertEquals("0", largestNumber(nums));
    }

    /**
     * Time: O(n log(n))
     * Space: O(n)
     */
    public String largestNumber(int[] nums) {
        //string valueOf strips leading zero
        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String result = String.join("", array);
        return result.startsWith("00") ? "0" : result;
    }
}
