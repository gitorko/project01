package com.demo.leetcode.medium._11_btfrompreinorder_105;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [105. Construct Binary Tree from Preorder and Inorder Traversal - MEDIUM](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
 *
 * - recursion, break middle
 * - SIMILAR_TO: [106. Construct Binary Tree from Inorder and Postorder Traversal - MEDIUM](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 *
 * https://www.youtube.com/watch?v=ihj4IQGZ2zc&ab_channel=NeetCode
 */
public class BTFromPreInOrder {

    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(3, 9, 20, 15, 7);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversal(root));
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length == 0)
            return null;

        //first element in preorder is root
        TreeNode root = new TreeNode(preorder[0]);
        int midIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                midIndex = i;
                break;
            }
        }
        //not including first element, as its already used
        int[] subLeftPre = Arrays.copyOfRange(preorder, 1, midIndex + 1);
        //not including mid, as its already used
        int[] subLeftIn = Arrays.copyOfRange(inorder, 0, midIndex);
        root.left = buildTree(subLeftPre, subLeftIn);

        int[] subRightPre = Arrays.copyOfRange(preorder, midIndex + 1, preorder.length);
        int[] subRightIn = Arrays.copyOfRange(inorder, midIndex + 1, inorder.length);
        root.right = buildTree(subRightPre, subRightIn);
        return root;
    }

}
