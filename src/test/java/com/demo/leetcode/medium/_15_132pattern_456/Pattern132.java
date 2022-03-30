package com.demo.leetcode.medium._15_132pattern_456;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [456. 132 Pattern - MEDIUM](https://leetcode.com/problems/132-pattern/)
 *
 * - monotonic stack, start from reverse
 */
public class Pattern132 {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(find132pattern(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3, 1, 4, 2};
        Assertions.assertTrue(find132pattern(nums));
    }

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // max stack
        int ak = Integer.MIN_VALUE;           // we want to find a seq ai < ak < aj

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < ak) // ai < ak, we're done because ai must also smaller than aj
                return true;
            while (!stack.isEmpty() && stack.peek() < nums[i])
                ak = stack.pop();
            stack.push(nums[i]); // nums[i] is a candidate of aj
        }
        return false;
    }
}
