package com.demo.leetcode.easy._01_missingnumber_268;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [268. Missing Number - EASY](https://leetcode.com/problems/missing-number/)
 *
 * - hashset will use O(n) space
 * - XOR
 * - binary search if sorted array then time becomes O(log(n))
 * - (Sum of 0..n) - (Sum of nums) = missing number
 *
 * https://www.youtube.com/watch?v=WnPLSRLSANE&ab_channel=NeetCode
 */
public class MissingNumber {

    @Test
    public void test() {
        int nums[] = {3, 0, 1};
        Assertions.assertEquals(2, missingNumber1(nums));
        Assertions.assertEquals(2, missingNumber2(nums));
        Assertions.assertEquals(2, missingNumber3(nums));
    }

    /**
     * XOR - 2 numbers which are same xor leads to 0.
     * Time: O(N)
     * Space: O(1)
     */
    public int missingNumber1(int[] nums) {
        //Add the last element to result to avoid index out of bounds.
        int result = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            result ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * (Sum of 0..n) - (Sum of nums) = missing number
     *
     * Time: O(N)
     * Space: O(1)
     */
    public int missingNumber2(int[] nums) {
        //Can also use Gauss formula to calculate sum
        //int sum = (len) * (len + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    /**
     * Sort, and binary search. mid element will be offset if there is missing number, so search only one side.
     * Time: O(n * log(n))
     * Time: O(log(n)) if array already sorted.
     * Space: O(1)
     */
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
