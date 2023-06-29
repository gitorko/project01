package com.demo.leetcode.medium._04_longesthappystring;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1405. Longest Happy String - MEDIUM](https://leetcode.com/problems/longest-happy-string/)
 *
 * - max heap
 * - break when count is zero
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=8u-H6O_XQKE&ab_channel=NeetCode
 */
public class HappyString {

    @Test
    public void test1() {
        Assertions.assertEquals("ccaccbcc", longestDiverseString(1, 1, 7));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("ccaccbcc", longestDiverseString(1, 1, 50));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public String longestDiverseString(int a, int b, int c) {
        //max heap
        PriorityQueue<Pair> queue = new PriorityQueue<>((x, y) -> y.count - x.count);
        queue.offer(new Pair('a', a));
        queue.offer(new Pair('b', b));
        queue.offer(new Pair('c', c));
        StringBuilder sb = new StringBuilder();
        while (true) {
            Pair curr = queue.poll();
            //if previous 2 char is also same then poll new char
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == curr.c && sb.charAt(sb.length() - 2) == curr.c) {
                Pair tmp = queue.poll();
                //put back current pair to queue
                queue.offer(curr);
                curr = tmp;
            }
            //count is 0 then end.
            if (curr.count == 0) {
                break;
            }
            sb.append(curr.c);
            curr.count--;
            queue.offer(curr);
        }
        return sb.toString();
    }

    class Pair {
        char c;
        int count;
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
