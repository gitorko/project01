package com.demo.leetcode.medium._01_robotincircle_1041;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1041. Robot Bounded In Circle - MEDIUM](https://leetcode.com/problems/robot-bounded-in-circle/)
 *
 * - if robot return to the origin, it is obviously in a circle.
 * - if robot finishes with face not towards north, it will get back to the initial status in another one or three sequences.
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=nKv2LnC_g6E&ab_channel=NeetCode
 */
public class RobotInCircle {

    @Test
    public void test() {
        Assertions.assertTrue(isRobotBounded("GGLLGG"));
        Assertions.assertFalse(isRobotBounded("GLGLGGLGL"));
        Assertions.assertTrue(isRobotBounded("LLGRL"));

        Assertions.assertTrue(isRobotBounded2("GGLLGG"));
        Assertions.assertFalse(isRobotBounded2("GLGLGGLGL"));
        Assertions.assertTrue(isRobotBounded2("LLGRL"));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
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

    /**
     * Time: O(4 * n)
     * Space: O(1)
     */
    public boolean isRobotBounded2(String instructions) {
        int dirX = 0;
        int dirY = 1;
        int x = 0;
        int y = 0;
        //After 4 times if the robot is at origin then in circle.
        for (int i = 1; i < 5; i++) {
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
        }
        return (x == 0 && y == 0);
    }
}
