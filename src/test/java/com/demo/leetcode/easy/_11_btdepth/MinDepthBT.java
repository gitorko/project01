package com.demo.leetcode.easy._11_btdepth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [111. Minimum Depth of Binary Tree - EASY](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
 *
 * - dfs - not optimal for min depth binary tree.
 * - bfs - optimal for min depth binary tree.
 *
 * PRACTICE
 */
public class MinDepthBT {

    @Test
    public void test1() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(2, minDepth(root));
        Assertions.assertEquals(2, minDepth2(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(2, null, 3, null, 4, null, 5, null, 6));
        TreeNodeUtil.printTree(root);
        Assertions.assertEquals(5, minDepth(root));
        Assertions.assertEquals(5, minDepth2(root));
    }

    /**
     * DFS - Not optimal
     * If the left subtree is very deep and complete, but right subtree is very shallow and sparse,
     * We will traverse almost the entire left subtree before moving on to right subtree
     * A BFS based solution will determine the depth faster
     *
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
     * EDGE CASE: a tree with only right side nodes
     * If left node is null it returns a 0, doesnt mean this is the min. Hence we can use the same logic of maxDepth
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * BFS - Optimal
     * if root's left subtree has a depth of 500 and the right subtree has a depth of 1,
     * by using bfs we wont have to traverse all the way to figure out min.
     */
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                //In level order traversal, node in the level that has both left and right null nodes then its the min
                if (node.left == null && node.right == null)
                    return level + 1;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            level++;
        }
        return level;
    }

}
