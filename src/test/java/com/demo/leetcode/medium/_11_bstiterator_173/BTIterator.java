package com.demo.leetcode.medium._11_bstiterator_173;

import java.util.Arrays;
import java.util.Stack;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
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
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(7, 3, 15, null, null, 9, 20));
        BSTIterator bSTIterator = new BSTIterator(root);
        Assertions.assertEquals(3, bSTIterator.next());    // return 3
        Assertions.assertEquals(7, bSTIterator.next());    // return 7
        Assertions.assertTrue(bSTIterator.hasNext()); // return True
        Assertions.assertEquals(9, bSTIterator.next());    // return 9
        Assertions.assertTrue(bSTIterator.hasNext()); // return True
        Assertions.assertEquals(15, bSTIterator.next());    // return 15
        Assertions.assertTrue(bSTIterator.hasNext()); // return True
        Assertions.assertEquals(20, bSTIterator.next());    // return 20
        Assertions.assertFalse(bSTIterator.hasNext()); // return False
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
