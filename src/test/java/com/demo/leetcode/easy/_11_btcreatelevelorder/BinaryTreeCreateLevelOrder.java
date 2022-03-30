package com.demo.leetcode.easy._11_btcreatelevelorder;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Create Binary Tree from Level order - EASY]()
 */
public class BinaryTreeCreateLevelOrder {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, null, 4));
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(1, 2, 3, null, 4);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3));
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversalWithNull(root));
    }
}
