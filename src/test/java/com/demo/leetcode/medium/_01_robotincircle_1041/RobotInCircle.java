package com.demo.leetcode.medium._01_robotincircle_1041;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1041. Robot Bounded In Circle - MEDIUM](https://leetcode.com/problems/robot-bounded-in-circle/)
 *
 * - if robot return to the origin, he is obvious in an circle.
 * - if robot finishes with face not towards north, it will get back to the initial status in another one or three sequences.
 *
 * https://www.youtube.com/watch?v=nKv2LnC_g6E&ab_channel=NeetCode
 */
public class RobotInCircle {

    @Test
    public void test1() {
        Assertions.assertTrue(isRobotBounded("GGLLGG"));
    }

    @Test
    public void test2() {
        Assertions.assertFalse(isRobotBounded("GLGLGGLGL"));
    }

    @Test
    public void test3() {
        Assertions.assertTrue(isRobotBounded("LLGRL"));
    }

    public boolean isRobotBounded(String instructions) {
        int dirX = 0;
        int dirY = 1;
        int x = 0;
        int y = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                x = x + dirX;
                y = y + dirY;
            } else if (c == 'L') {
                int temp = dirX;
                dirX = -1 * dirY;
                dirY = temp;
            } else {
                int temp = dirX;
                dirX = dirY;
                dirY = -1 * temp;
            }
        }
        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }
}
