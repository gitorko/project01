package com.demo.leetcode.medium._09_allbinaryfulltree_894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [894. All Possible Full Binary Trees - MEDIUM](https://leetcode.com/problems/all-possible-full-binary-trees/)
 *
 * - recursion
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=nZtrZPTTCAo&ab_channel=NeetCode
 */
public class AllBinaryFullTree {

    @Test
    public void test() {
        Assertions.assertEquals(5, allPossibleFBT(7).size());
    }

    /**
     * Time: O(2^n)
     * Space: O(2^n)
     */
    private Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        //cant make full binary tree with even nodes
        if (n == 0 || n % 2 == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int leftCount = 0; leftCount < n; leftCount++) {
            int rightCount = n - 1 - leftCount;
            for (TreeNode left : allPossibleFBT(leftCount)) {
                for (TreeNode right : allPossibleFBT(rightCount)) {
                    TreeNode newNode = new TreeNode(0);
                    newNode.left = left;
                    newNode.right = right;
                    result.add(newNode);
                }
            }
        }
        dp.put(n, result);
        return result;
    }

}
