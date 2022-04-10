package com.demo.leetcode.easy._11_bttraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [144. Binary Tree Preorder Traversal - EASY](https://leetcode.com/problems/binary-tree-preorder-traversal/)
 * [145. Binary Tree Postorder Traversal- EASY](https://leetcode.com/problems/binary-tree-postorder-traversal/)
 * [94. Binary Tree Inorder Traversal - EASY](https://leetcode.com/problems/binary-tree-inorder-traversal/)
 * [102. Binary Tree Level Order Traversal - EASY](https://leetcode.com/problems/binary-tree-level-order-traversal/)
 *
 * - BFS needs a Queue.
 * - PREORDER  - V L R
 * - INORDER   - L V R
 * - POSTORDER - L R V
 *
 * MEMORIZE
 *
 * https://www.youtube.com/watch?v=6ZnyEApgFYg&ab_channel=NeetCode
 */
public class BTTraversal {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(26, 10, 3, 6, 4, 1, 3));

        //In order
        Assertions.assertEquals(Arrays.asList(6, 10, 4, 26, 1, 3, 3), inorderTraversal(root));

        //Pre order
        Assertions.assertEquals(Arrays.asList(26, 10, 6, 4, 3, 1, 3), preorderTraversal(root));

        //Post order
        Assertions.assertEquals(Arrays.asList(6, 4, 10, 1, 3, 3, 26), postorderTraversal(root));

        //Level order
        Assertions.assertEquals(Arrays.asList(26, 10, 3, 6, 4, 1, 3), levelOrderTraversal(root));

        //Level order
        Assertions.assertEquals(Arrays.asList(Arrays.asList(26), Arrays.asList(10, 3), Arrays.asList(6, 4, 1, 3)), levelOrder(root));

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.add(root.val);
            numLst.addAll(preorderTraversal(root.left));
            numLst.addAll(preorderTraversal(root.right));
        }
        return numLst;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.addAll(inorderTraversal(root.left));
            numLst.add(root.val);
            numLst.addAll(inorderTraversal(root.right));
        }
        return numLst;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.addAll(postorderTraversal(root.left));
            numLst.addAll(postorderTraversal(root.right));
            numLst.add(root.val);
        }
        return numLst;
    }

    /**
     * BFS
     * Time: O(N)
     * Space: Space O(N)
     */
    public List<Integer> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        //edge case
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * Same as above but returns list of list.
     * Need to track level - 2 while loop
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                subList.add(node.val);
                size--;
            }
            result.add(subList);
        }
        return result;
    }
}
