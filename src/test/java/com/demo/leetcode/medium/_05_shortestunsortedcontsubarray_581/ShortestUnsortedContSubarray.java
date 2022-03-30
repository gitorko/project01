package com.demo.leetcode.medium._05_shortestunsortedcontsubarray_581;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [581. Shortest Unsorted Continuous Subarray - MEDIUM](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)
 *
 * - two pointer
 */
public class ShortestUnsortedContSubarray {

    @Test
    public void test() {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        Assertions.assertEquals(5, findUnsortedSubarray(nums));
        Assertions.assertEquals(5, findUnsortedSubarray2(nums));
    }

    /**
     * Time: O(n*log(n))
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int left = 0;
        while (left < n && nums[left] == temp[left]) left++;

        int right = n - 1;
        while (right > left && nums[right] == temp[right]) right--;

        return right - left + 1;
    }

    /**
     * Time: O(n)
     */
    public int findUnsortedSubarray2(int[] nums) {
        int leftIndex = -1;
        int rightIndex = -1;

        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxSoFar) {
                maxSoFar = nums[i];
            }
            if (nums[i] < maxSoFar) {
                rightIndex = i;
            }
        }

        int minSoFar = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < minSoFar) {
                minSoFar = nums[i];
            }
            if (nums[i] > minSoFar) {
                leftIndex = i;
            }
        }
        return leftIndex == -1 ? 0 : rightIndex - leftIndex + 1;
    }
}
