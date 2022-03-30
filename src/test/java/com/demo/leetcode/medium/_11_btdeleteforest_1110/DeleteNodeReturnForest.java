package com.demo.leetcode.medium._11_btdeleteforest_1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Test;

/**
 * [1110. Delete Nodes And Return Forest - MEDIUM](https://leetcode.com/problems/delete-nodes-and-return-forest/)
 *
 * - post-order traversal
 * - set to hold nodes to delete
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=PZJj8pHz54M&ab_channel=AmellPeralta
 */
public class DeleteNodeReturnForest {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int[] to_delete = {3, 5};
        List<TreeNode> result = delNodes(root, to_delete);
        for (TreeNode t : result) {
            System.out.println(TreeNodeUtil.levelOrderTraversalWithNull(t));
        }
    }

    /**
     * Time: O(m+n) , where m is length of array, n is nodes in tree
     * Time: O(m+h)
     */
    Set<Integer> toDeleteSet;
    List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        if (root == null) return result;

        //add to set for quick lookup.
        toDeleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());

        removeNodes(root);

        //if root node didnt get deleted then we have to add that to result.
        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }
        return result;
    }

    private TreeNode removeNodes(TreeNode node) {
        if (node == null) return null;
        //post-order
        node.left = removeNodes(node.left);
        node.right = removeNodes(node.right);

        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) result.add(node.left);
            if (node.right != null) result.add(node.right);
            return null;
        }
        return node;
    }
}
