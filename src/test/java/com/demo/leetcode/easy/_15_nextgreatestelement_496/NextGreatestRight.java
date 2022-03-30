package com.demo.leetcode.easy._15_nextgreatestelement_496;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Nearest greater to right - EASY]()
 *
 * - start from reverse, use stack
 * - SIMILAR_TO: Nearest Greater to Right
 * - SIMILAR_TO: Nearest Greater to Left
 * - SIMILAR_TO: Nearest Smaller to Right
 * - SIMILAR_TO: Nearest Smaller to Left
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&ab_channel=AdityaVerma
 */
public class NextGreatestRight {

    @Test
    public void test2() {
        int[] nums = {1, 3, 2, 4};
        int[] expected = {3, 4, 4, -1};
        Assertions.assertArrayEquals(expected, nextGreaterElement(nums));
    }

    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            }
            if (!stack.isEmpty() && stack.peek() > nums[i]) {
                result[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return result;
    }
}
