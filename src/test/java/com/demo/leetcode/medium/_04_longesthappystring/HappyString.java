package com.demo.leetcode.medium._04_longesthappystring;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1405. Longest Happy String - MEDIUM](https://leetcode.com/problems/longest-happy-string/)
 *
 * - max heap with int pair
 * - string builder
 * - curr[1] == 0 break
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=8u-H6O_XQKE&ab_channel=NeetCode
 */
public class HappyString {

    @Test
    public void test() {
        Assertions.assertEquals("ccaccbcc", longestDiverseString(1, 1, 7));
    }

    public String longestDiverseString(int a, int b, int c) {
        //max heap
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        //0 index is a, 1 index is b, 2 index is c
        queue.offer(new int[]{0, a});
        queue.offer(new int[]{1, b});
        queue.offer(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] curr = queue.poll();
            //if previous 2 char is also same then poll new char
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) - 'a' == curr[0] && sb.charAt(sb.length() - 2) - 'a' == curr[0]) {
                int[] tmp = queue.poll();
                queue.offer(curr);
                curr = tmp;
            }
            //count is 0 then end.
            if (curr[1] == 0) break;

            sb.append((char) ('a' + curr[0]));
            curr[1]--;
            queue.offer(curr);
        }
        return sb.toString();
    }
}
