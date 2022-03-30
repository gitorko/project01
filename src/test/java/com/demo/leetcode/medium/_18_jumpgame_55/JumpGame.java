package com.demo.leetcode.medium._18_jumpgame_55;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [55. Jump Game - MEDIUM](https://leetcode.com/problems/jump-game/)
 *
 * - goal post, start from reverse
 *
 * https://www.youtube.com/watch?v=Yan0cv2cLy8&ab_channel=NeetCode
 */
public class JumpGame {

    @Test
    public void test() {
        int nums[] = {2, 3, 1, 1, 4};
        Assertions.assertTrue(canJump(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
