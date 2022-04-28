package com.demo.leetcode.hard._01_trappingrainwater_42;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [42. Trapping Rain Water - HARD](https://leetcode.com/problems/trapping-rain-water/)
 *
 * - 3 array, maxLeft, maxRight, min(L,R) arrays.
 * - min(maxLeft,maxRight) - height[i]
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=ZI2z5pq0TqA&ab_channel=NeetCode
 */
public class TrappingRainWater {

    @Test
    public void test1() {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assertions.assertEquals(6, trap1(height));
        Assertions.assertEquals(6, trap2(height));
    }

    @Test
    public void test2() {
        int height[] = {2, 0, 1, 3};
        Assertions.assertEquals(3, trap1(height));
        Assertions.assertEquals(3, trap2(height));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int trap1(int[] height) {
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];
        int minArr[] = new int[height.length];
        int result[] = new int[height.length];
        int max = 0;
        //max left height
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        //max right height
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        //min array
        for (int i = 0; i < height.length; i++) {
            minArr[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int diff = minArr[i] - height[i];
            if (diff > 0) {
                result[i] = diff;
            }
        }

        return Arrays.stream(result).sum();
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                result += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return result;
    }

}
