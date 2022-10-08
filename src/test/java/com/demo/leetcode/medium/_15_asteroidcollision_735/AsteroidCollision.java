package com.demo.leetcode.medium._15_asteroidcollision_735;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [735. Asteroid Collision - MEDIUM](https://leetcode.com/problems/asteroid-collision/)
 *
 * - stacks
 * - positive & negative case. Math.abs
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=LN7KjRszjk4&ab_channel=NeetCode
 */
public class AsteroidCollision {

    @Test
    public void test1() {
        int asteroids[] = {5, 10, -5};
        int expected[] = {5, 10};
        Assertions.assertArrayEquals(expected, asteroidCollision(asteroids));

    }

    @Test
    public void test2() {
        int asteroids[] = {-1, 3, 2, -3};
        int expected[] = {-1};
        Assertions.assertArrayEquals(expected, asteroidCollision(asteroids));
        Assertions.assertArrayEquals(expected, asteroidCollision(asteroids));
    }

    @Test
    public void test3() {
        int asteroids[] = {-2, -1, 1, 2};
        int expected[] = {-2, -1, 1, 2};
        Assertions.assertArrayEquals(expected, asteroidCollision(asteroids));
    }

    @Test
    public void test4() {
        int asteroids[] = {10, 2, -5};
        int expected[] = {10};
        Assertions.assertArrayEquals(expected, asteroidCollision(asteroids));
    }

    /**
     * If the asteroid is with + sign, simply push onto stack since it can't collide
     *
     * If the asteroid is with - sign, there can be few cases :
     *  1. if stack top is +ve & absolute value is lesser than the asteroid, then it has to be blown off, so pop it off.
     *  2. if the stack top is also -ve, simply push the asteroid, no question of collision since both move in left direction.
     *  3. if the absolute value of asteroid & stack top are same, both would be blown off, so effectively pop off from stack & do nothing with the current asteroid.
     *
     *  Time: O(n)
     *  Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            //push positive numbers to stack
            if (a > 0) {
                stack.push(a);
            } else {
                // if collision happens remove all elements
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                // Checking if the stack is empty or top of stack is negative
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
                // if both are equal they destroy each other
                else if (stack.peek() == Math.abs(a)) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }
}
