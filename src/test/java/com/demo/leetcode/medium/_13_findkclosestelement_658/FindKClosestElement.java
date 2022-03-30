package com.demo.leetcode.medium._13_findkclosestelement_658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [658. Find K Closest Elements - MEDIUM](https://leetcode.com/problems/find-k-closest-elements/)
 *
 * - binary search, two pointer, target doesnt exist
 * - instead of searching for mid, keep moving window
 * - (x-arr[mid]), (arr[mid + k]-x)
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=o-YDQzHoaKM&ab_channel=NeetCode
 */
public class FindKClosestElement {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(expected, findClosestElements(arr, k, x));
    }

    @Test
    public void test2() {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2, x = 5;
        List<Integer> expected = Arrays.asList(4, 5);
        Assertions.assertEquals(expected, findClosestElements(arr, k, x));
    }

    /**
     * Time: O(log(n - k) + k)
     * Space: O(K)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            //x is greater than mid
            int diffAtMid = x - arr[mid];
            //x is lesser than mid
            int diffAtMidPlusK = arr[mid + k] - x;
            if (diffAtMid > diffAtMidPlusK)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}
