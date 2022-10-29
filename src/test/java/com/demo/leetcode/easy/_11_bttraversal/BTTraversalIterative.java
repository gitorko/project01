package com.demo.leetcode.easy._11_bttraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [144. Binary Tree Preorder Traversal - EASY](https://leetcode.com/problems/binary-tree-preorder-traversal/)
 * [145. Binary Tree Postorder Traversal - EASY](https://leetcode.com/problems/binary-tree-postorder-traversal/)
 * [94. Binary Tree Inorder Traversal - EASY](https://leetcode.com/problems/binary-tree-inorder-traversal/)
 *
 * - iterative approach
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=nzmtCFNae9k&ab_channel=TusharRoy-CodingMadeSimple
 */
public class BTTraversalIterative {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(26, 10, 3, 6, 4, 1, 3));

        //In order
        List<Integer> actual = inOrderIterative(root);
        Assertions.assertEquals(Arrays.asList(6, 10, 4, 26, 1, 3, 3), actual);

        //Pre order
        actual = preOrderIterative(root);
        Assertions.assertEquals(Arrays.asList(26, 10, 6, 4, 3, 1, 3), actual);

        //Post order
        actual = postOrderIterative(root);
        Assertions.assertEquals(Arrays.asList(6, 4, 10, 1, 3, 3, 26), actual);
    }

    /**
     * One stack, 2 while loop
     * Time: O(N)
     * Space: O(h)
     */
    public List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //edge case
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * One stack, insert right first.
     *
     * Time: O(n)
     * Space: O(h) h = height of binary tree, worst case: height = n
     */
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root == null) {
            return numLst;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            numLst.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return numLst;
    }

    /**
     * One stacks, insert left, right.
     */
    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root == null) {
            return numLst;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            numLst.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(numLst);
        return numLst;
    }

}
