package com.demo.leetcode.medium._01_shufflearray;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * [Shuffle Array - MEDIUM]()
 *
 * - random
 */
public class ShuffleArray {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        int[] shuffled = solution.shuffle();
        System.out.println(Arrays.toString(shuffled));
    }

    class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if (nums == null) return null;
            int[] a = nums.clone();
            for (int j = 1; j < a.length; j++) {
                int i = random.nextInt(j + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
