package com.demo.leetcode.medium._09_uniquebinarysearchtree2_95;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [95. Unique Binary Search Trees II - MEDIUM](https://leetcode.com/problems/unique-binary-search-trees-ii/)
 *
 * - backtracking
 *
 * PRACTICE
 */
public class UniqueBST2 {

    @Test
    public void test() {
        List<TreeNode> treeNodes = generateTrees(3);
        Assertions.assertEquals(5, treeNodes.size());
    }

    /**
     * Time: O(3^n)
     * Space: O(3^n)
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int min, int max) {
        if (min > max)
            return Arrays.asList((TreeNode) null);

        List<TreeNode> result = new ArrayList<>();

        for (int i = min; i <= max; i++)
            for (TreeNode left : generateTrees(min, i - 1))
                for (TreeNode right : generateTrees(i + 1, max)) {
                    result.add(new TreeNode(i));
                    result.get(result.size() - 1).left = left;
                    result.get(result.size() - 1).right = right;
                }
        return result;
    }
}
