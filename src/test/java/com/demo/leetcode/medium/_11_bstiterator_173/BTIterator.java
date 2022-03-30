package com.demo.leetcode.medium._11_bstiterator_173;

import java.util.Arrays;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Test;

/**
 * [173. Binary Search Tree Iterator - MEDIUM](https://leetcode.com/problems/binary-search-tree-iterator/)
 *
 * - iterative in order traversal
 * - stack
 *
 * https://www.youtube.com/watch?v=RXy5RzGF5wo&ab_channel=NeetCode
 */
public class BTIterator {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));
        TreeNodeUtil.printTree(root);
    }

    /**
     * Time: Constructor: O(h), next(): O(h), hasNext(): O(1)
     * Space: O(h)
     */
    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushLeftsUntilNull(root);
        }

        public int next() {
            TreeNode root = stack.pop();
            pushLeftsUntilNull(root.right);
            return root.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeftsUntilNull(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }
}
