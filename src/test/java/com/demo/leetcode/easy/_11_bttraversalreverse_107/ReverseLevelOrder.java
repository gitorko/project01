package com.demo.leetcode.easy._11_bttraversalreverse_107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [107. Binary Tree Level Order Traversal II - EASY](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
 *
 * - use queue + stack
 *
 * https://www.youtube.com/watch?v=D2bIbWGgvzI&ab_channel=TusharRoy-CodingMadeSimple
 */
public class ReverseLevelOrder {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(40, 50, 60, 70, 20, 30, 10);
        Assertions.assertEquals(expected, reverseLevelOrderTraversal(root));
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<Integer> reverseLevelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if (root == null)
            return Collections.emptyList();

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        q.offer(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) {
                q.offer(root.right);
            }
            if (root.left != null) {
                q.offer(root.left);
            }
            s.push(root);
        }
        while (!s.isEmpty()) {
            result.add(s.pop().val);
        }
        return result;
    }
}
