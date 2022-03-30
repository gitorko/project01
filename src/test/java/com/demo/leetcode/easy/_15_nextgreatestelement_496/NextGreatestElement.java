package com.demo.leetcode.easy._15_nextgreatestelement_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [496. Next Greater Element I - EASY](https://leetcode.com/problems/next-greater-element-i/)
 *
 * - monotonic stack, map
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=68a1Dc_qVq4&ab_channel=NeetCode
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&ab_channel=AdityaVerma
 */
public class NextGreatestElement {

    @Test
    public void test1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};
        Assertions.assertArrayEquals(expected, nextGreaterElement(nums1, nums2));
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 3, 2, 4};
        int[] nums2 = {1, 3, 2, 4};
        int[] expected = {3, 4, 4, -1};
        Assertions.assertArrayEquals(expected, nextGreaterElement(nums1, nums2));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToNextGreater = new HashMap<>();
        // decreasing stack
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                numToNextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numToNextGreater.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
