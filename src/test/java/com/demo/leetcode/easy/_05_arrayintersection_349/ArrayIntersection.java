package com.demo.leetcode.easy._05_arrayintersection_349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [349. Intersection of Two Arrays - EASY](https://leetcode.com/problems/intersection-of-two-arrays/)
 *
 * - two pointer
 *
 * PRACTICE
 */
public class ArrayIntersection {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, intersection(nums1, nums2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        for (int num : nums2)
            if (set.remove(num))
                result.add(num);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Time: O(n * log(n))
     * Space: O(n)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
