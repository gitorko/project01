package com.demo.leetcode.medium._02_pushdomino_838;


import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [838. Push Dominoes - MEDIUM](https://leetcode.com/problems/push-dominoes/)
 *
 * - queue
 *
 * https://www.youtube.com/watch?v=evUFsOb_iLY&ab_channel=NeetCode
 */
public class PushDomino {

    @Test
    public void test() {
        Assertions.assertEquals("RR.L", pushDominoes("RR.L"));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < d.length; i++) {
            if (d[i] != '.') {
                queue.add(new Pair(d[i], i));
            }
        }
        while (!queue.isEmpty()) {
            Pair item = queue.poll();
            int i = item.index;
            int c = item.c;
            if (c == 'L') {
                //Not checking 'R' because we are going from left to right and if right present then already processed.
                if (i > 0 && d[i - 1] == '.') {
                    queue.add(new Pair('L', i - 1));
                    d[i - 1] = 'L';
                }
            }
            if (c == 'R') {
                if (i + 1 < d.length && d[i + 1] == '.') {
                    //two cases
                    if (i + 2 < d.length && d[i + 2] == 'L') {
                        //remove the left domino
                        queue.poll();
                    } else {
                        queue.add(new Pair('R', i + 1));
                        d[i + 1] = 'R';
                    }
                }

            }
        }
        return new String(d);
    }

    class Pair {
        Character c;
        Integer index;

        public Pair(Character c, Integer index) {
            this.c = c;
            this.index = index;
        }
    }
}
