package com.demo.leetcode.medium._09_uniquebinarysearchtree_96;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [96. Unique Binary Search Trees - MEDIUM](https://leetcode.com/problems/unique-binary-search-trees/)
 *
 * - nothing to do with BST, it's a DP problem
 * - SIMILAR_TO: [95. Unique Binary Search Trees II - MEDIUM](https://leetcode.com/problems/unique-binary-search-trees-ii/)
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=Ox0TenN3Zpg&ab_channel=NeetCode
 */
public class UniqueBST {

    @Test
    public void test1() {
        Assertions.assertEquals(5, numTrees(3));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, numTrees(1));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(2, numTrees(2));
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     *
     * numTree[4] = numTree[0]* numTree[3] +
     *              numTree[1]* numTree[2] +
     *              numTree[2]* numTree[1] +
     *              numTree[3]* numTree[0] +
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //base case set to 1.
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level < n + 1; level++) {
            for (int root = 1; root < level + 1; root++) {
                int left = root - 1;
                int right = level - root;
                dp[level] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
