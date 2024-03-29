package com.demo.leetcode.medium._18_jumpgame2_45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [45. Jump Game II - MEDIUM](https://leetcode.com/problems/jump-game-ii/)
 *
 * - two pointer, farthest
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=dJ7sWiOoK7g&ab_channel=NeetCode
 */
public class JumpGame2 {

    @Test
    public void test() {
        int nums[] = {2, 3, 1, 1, 4};
        Assertions.assertEquals(2, jump(nums));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        int farthest = 0;
        while (right < nums.length - 1) {
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps += 1;
        }
        return jumps;
    }
}
