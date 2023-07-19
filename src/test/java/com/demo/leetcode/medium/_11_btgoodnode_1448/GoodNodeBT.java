package com.demo.leetcode.medium._11_btgoodnode_1448;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1448. Count Good Nodes in Binary Tree - MEDIUM](https://leetcode.com/problems/count-good-nodes-in-binary-tree/)
 *
 * - pre-order traversal along with passing max value upto that point.
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=7cp5imvDzl4&ab_channel=NeetCode
 */
public class GoodNodeBT {

    @Test
    public void test() {
        List<Integer> treeData = Arrays.asList(3, 1, 4, 3, null, 1, 5);
        TreeNode root = TreeNodeUtil.insertLevelOrder(treeData);
        Assertions.assertEquals(4, goodNodes(root));
    }

    /**
     * Time: O(n)
     * Space: O(h)
     */
    public int goodNodes(TreeNode root) {
        //root node is always good node.
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int result = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        result += goodNodes(root.left, max);
        result += goodNodes(root.right, max);
        return result;
    }
}
