package com.demo.leetcode.hard._21_findmissingpositive_41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [41. First Missing Positive - HARD](https://leetcode.com/problems/first-missing-positive/)
 *
 * - option1: sort and iterate - O(n*log(n))
 * - option2: cyclic sort, ignore out of bounds
 * - SIMILAR_TO: [448. Find All Numbers Disappeared in an Array - EASY](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
 * - PRACTICE: P1
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
            int index = Math.abs(nums[i]);
            //index should be in bounds
            if (index >= 1 && index <= nums.length) {
                if (nums[index - 1] > 0) {
                    nums[index - 1] *= -1;
                } else if (nums[index - 1] == 0) {
                    nums[index - 1] = -1 * (nums.length + 1);
                }
            }
        }
        //starts from 1 but check previous element
        for (int i = 1; i < nums.length + 1; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        return nums.length + 1;
    }
}
