package com.demo.theory._004_morristraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.demo.common.TreeNodeUtil;
import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * InOrder traversal with inplace tree modification
 *
 * HINT:
 * InOrder traversal with inplace tree modification
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * Inorder traversal without stack and recursion.
 * Although the tree is modified through the traversal, it is reverted back to its original shape
 *
 * TYPE: HARD
 *
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 */
public class MorrisTraversal {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(26, 10, 3, 6, 4, 1, 3));
        //In order
        List<Integer> actual = morrisTraversal(root);
        Assertions.assertEquals(Arrays.asList(6, 10, 4, 26, 1, 3, 3), actual);
    }

    /**
     * HARD
     */
    public List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        TreeNode current, pre;
        if (root == null) {
            return Collections.emptyList();
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                numLst.add(current.val);
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in if part to restore the
                   original tree i.e.,fix the right child of predecssor*/
                else {
                    pre.right = null;
                    numLst.add(current.val);
                    System.out.print(current.val + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
        return numLst;
    }
}
