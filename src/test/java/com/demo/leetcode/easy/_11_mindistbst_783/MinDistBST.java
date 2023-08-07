package com.demo.leetcode.easy._11_mindistbst_783;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [783. Minimum Distance Between BST Nodes - EASY](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)
 *
 * - in-order traversal
 *
 * https://www.youtube.com/watch?v=joxx4hTYwcw&ab_channel=NeetCodeIO
 */
public class MinDistBST {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(4, 2, 6, 1, 3));
        Assertions.assertEquals(1, minDiffInBST(root));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    Integer result = Integer.MAX_VALUE;
    Integer previous = null;

    public int minDiffInBST(TreeNode root) {
        //base case
        if (root == null) {
            //don't return 0, return MAX as it shouldn't contribute to the result.
            return Integer.MAX_VALUE;
        }
        minDiffInBST(root.left);
        if (previous != null) {
            result = Math.min(result, root.val - previous);
        }
        previous = root.val;
        minDiffInBST(root.right);
        return result;
    }

}
