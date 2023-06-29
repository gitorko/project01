package com.demo.leetcode.medium._13_findkclosestelement_658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [658. Find K Closest Elements - MEDIUM](https://leetcode.com/problems/find-k-closest-elements/)
 *
 * - binary search
 * - search entire window
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=o-YDQzHoaKM&ab_channel=NeetCode
 */
public class FindKClosestElement {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 4, target = 3;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(expected, findClosestElements(arr, k, target));
    }

    @Test
    public void test2() {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2, target = 5;
        List<Integer> expected = Arrays.asList(4, 5);
        Assertions.assertEquals(expected, findClosestElements(arr, k, target));
    }

    /**
     * Time: O(log(n - k) + k)
     * Space: O(k)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int target) {
        int left = 0;
        //right index is less by k
        int right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            //target is greater than mid
            int diffAtMid = target - arr[mid];
            //target is lesser than mid
            int diffAtMidPlusK = arr[mid + k] - target;
            if (diffAtMid > diffAtMidPlusK) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}
