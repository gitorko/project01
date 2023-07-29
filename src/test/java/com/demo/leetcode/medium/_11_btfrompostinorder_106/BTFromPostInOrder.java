package com.demo.leetcode.medium._11_btfrompostinorder_106;

import java.util.Arrays;
import java.util.List;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [106. Construct Binary Tree from Inorder and Postorder Traversal - MEDIUM](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 *
 * - recursion
 * - SIMILAR_TO: [105. Construct Binary Tree from Preorder and Inorder Traversal - MEDIUM](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
 */
public class BTFromPostInOrder {

    @Test
    public void test() {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(inorder, postorder);
        TreeNodeUtil.printTree(root);
        List<Integer> expected = Arrays.asList(3, 9, 20, 15, 7);
        Assertions.assertEquals(expected, TreeNodeUtil.levelOrderTraversal(root));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        //last element in postorder is root
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int midIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                midIndex = i;
                break;
            }
        }
        int[] subLeftPost = Arrays.copyOfRange(postorder, 0, midIndex);
        int[] subLeftIn = Arrays.copyOfRange(inorder, 0, midIndex);
        root.left = buildTree(subLeftIn, subLeftPost);

        //not including last element, as its already used
        int[] subRightPost = Arrays.copyOfRange(postorder, midIndex, postorder.length - 1);
        //not including mid, as its already used
        int[] subRightIn = Arrays.copyOfRange(inorder, midIndex + 1, inorder.length);
        root.right = buildTree(subRightIn, subRightPost);
        return root;
    }
}
