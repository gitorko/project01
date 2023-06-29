package com.demo.leetcode.medium._01_mindominorotation_1007;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1007. Minimum Domino Rotations For Equal Row - MEDIUM](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/)
 *
 * https://www.youtube.com/watch?v=VD9NACqBCw4&ab_channel=NeetCode
 */
public class MinDominoRotation {

    @Test
    public void test() {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        Assertions.assertEquals(2, minDominoRotations(tops, bottoms));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        for (int i = 0; i < tops.length; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; i++) {
            //Need 6 same values in either row, subtract same count to avoid double count
            //result exists only if countA[i] + countB[i] - same[i] == tops.length then
            if (countA[i] + countB[i] - same[i] == tops.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }
}
