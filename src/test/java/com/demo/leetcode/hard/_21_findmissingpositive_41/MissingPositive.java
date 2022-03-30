package com.demo.leetcode.hard._21_findmissingpositive_41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [41. First Missing Positive - HARD](https://leetcode.com/problems/first-missing-positive/)
 *
 * - 3 for loops
 * - Sort and iterate - n*log(n)
 *
 * https://www.youtube.com/watch?v=8g78yfzMlao&ab_channel=NeetCode
 */
public class MissingPositive {

    @Test
    public void test() {
        int[] nums = {3, 4, -1, 1};
        Assertions.assertEquals(2, firstMissingPositive(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 0};
        Assertions.assertEquals(3, firstMissingPositive(nums));
    }

    @Test
    public void test3() {
        int[] nums = {0, 1, 2};
        Assertions.assertEquals(3, firstMissingPositive(nums));
    }

    /**
     * Time: O(n)
     * Space : O(1)
     */
    public int firstMissingPositive(int[] nums) {
        //remove negatives
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            //val should be in bounds
            if (val >= 1 && val <= nums.length) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                }
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
