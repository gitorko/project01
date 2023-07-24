package com.demo.leetcode.medium._18_jumpgame7_1871;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1871. Jump Game VII - MEDIUM](https://leetcode.com/problems/jump-game-vii/)
 *
 * - queue bfs, farthest
 * - SIMILAR_TO: [45. Jump Game II - MEDIUM](https://leetcode.com/problems/jump-game-ii/)
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=v1HpZUnQ4Yo&ab_channel=NeetCode
 */
public class JumpGame7 {

    @Test
    public void test1() {
        String s = "011010";
        int minJump = 2, maxJump = 3;
        Assertions.assertTrue(canReach(s, minJump, maxJump));
        Assertions.assertTrue(canReach2(s, minJump, maxJump));
    }

    @Test
    public void test2() {
        String s = "01";
        int minJump = 1, maxJump = 1;
        Assertions.assertFalse(canReach(s, minJump, maxJump));
        Assertions.assertFalse(canReach2(s, minJump, maxJump));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        //[indexes]
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int farthest = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, s.length());
            for (int j = start; j < end + 1; j++) {
                if (s.charAt(j) == '0') {
                    queue.offer(j);
                    //reached the end.
                    if (j == s.length() - 1) {
                        return true;
                    }
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }

    /**
     * dp approach
     * Time: O(n * j) n is number of position, j is range of jump
     * Space: O(n)
     */
    public boolean canReach2(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        char[] ch = s.toCharArray();
        dp[0] = ch[0] == '0';
        int reachable = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                reachable += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                reachable -= dp[i - maxJump - 1] ? 1 : 0;
            }
            dp[i] = reachable > 0 && ch[i] == '0';
        }
        return dp[n - 1];
    }

}
