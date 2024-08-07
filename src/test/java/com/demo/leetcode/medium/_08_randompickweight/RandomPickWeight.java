package com.demo.leetcode.medium._08_randompickweight;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * [528. Random Pick with Weight - MEDIUM](https://leetcode.com/problems/random-pick-with-weight/)
 *
 * - prefix sum + binary search
 *
 * https://www.youtube.com/watch?v=fWS0TCcr-lE&ab_channel=TECHDOSE
 */
public class RandomPickWeight {

    @Test
    @Disabled
    public void test1() {
        int[] input = {1};
        Solution solution = new Solution(input);
        //The only option is to return 0 since there is only one element in w.
        Assertions.assertEquals(0, solution.pickIndex());
    }

    @Test
    @Disabled
    public void test2() {
        int[] input = {1, 3};
        Solution solution = new Solution(input);
        //The only option is to return 0 since there is only one element in w.
        Assertions.assertEquals(1, solution.pickIndex());
    }

    /**
     * Time: Constructor: O(n), pickIndex(): O(log n)
     * Space: O(n)
     */
    class Solution {

        private int[] prefix;
        private Random rand = new Random();

        public Solution(int[] w) {
            prefix = w;
            for (int i = 1; i < prefix.length; i++)
                prefix[i] += prefix[i - 1];
        }

        public int pickIndex() {
            int target = rand.nextInt(prefix[prefix.length - 1]);
            int l = 0;
            int r = prefix.length;

            while (l < r) {
                int m = (l + r) / 2;
                if (prefix[m] > target)
                    r = m;
                else
                    l = m + 1;
            }

            return l;
        }
    }

}
