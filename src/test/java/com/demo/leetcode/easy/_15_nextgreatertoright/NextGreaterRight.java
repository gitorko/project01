package com.demo.leetcode.easy._15_nextgreatertoright;

import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Nearest Greater to Right - EASY]()
 *
 * - monotonic stack (decreasing)
 * - PRACTICE: P1
 * - SIMILAR_TO: [901. Online Stock Span - MEDIUM](https://leetcode.com/problems/online-stock-span/)
 */
public class NextGreaterRight {

    @Test
    public void test1() {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        int[] expected = {1, 1, 1, 2, 1, 4, 6};
        int[] result = nextGreater(nums);
        System.out.println(Arrays.toString(result));
        Assertions.assertArrayEquals(expected, result);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] nextGreater(int[] nums) {
        // (nearest great element, index)
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = i - (-1);
            }
            if (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                result[i] = i - stack.peek()[1];
            }
            stack.push(new int[]{nums[i], i});
        }
        return result;
    }
}
