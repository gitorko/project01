package com.demo.basics.datastructure;

import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Insert to BST, Delete from BST, Find from BST -EASY]()
 *
 * - Non Balanced BST - Search is O(n) (if nodes only on one side)
 * - Balanced BST - Search is O(log n)
 *
 * https://www.youtube.com/watch?v=zm83jPHZ-jA&ab_channel=TusharRoy-CodingMadeSimple
 * https://www.youtube.com/watch?v=bmaeYtlO2OE&ab_channel=TusharRoy-CodingMadeSimple
 */
public class CustomBST {

    @Test
    public void test() {

        CustomBST bt = new CustomBST();
        TreeNode root = bt.insertNodeIterative(null, 50);
        root = bt.insertNodeIterative(root, 50);
        root = bt.insertNodeIterative(root, 25);
        root = bt.insertNodeIterative(root, 15);
        root = bt.insertNodeIterative(root, 30);
        root = bt.insertNodeIterative(root, 75);
        root = bt.insertNodeIterative(root, 85);

        Assertions.assertTrue(bt.findIterative(root, 30));
        Assertions.assertTrue(bt.findRecursive(root, 30));
    }

    @Test
    public void test2() {

        CustomBST bt = new CustomBST();
        TreeNode root = bt.insertNodeRecursive(null, 50);
        root = bt.insertNodeRecursive(root, 50);
        root = bt.insertNodeRecursive(root, 25);
        root = bt.insertNodeRecursive(root, 15);
        root = bt.insertNodeIterative(root, 30);
        root = bt.insertNodeRecursive(root, 75);
        root = bt.insertNodeRecursive(root, 85);

        bt.deleteRecursive(root, 30);

        Assertions.assertFalse(bt.findIterative(root, 30));
    }

    /**
     * Insert iterative
     */
    public TreeNode insertNodeIterative(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;

        TreeNode parent = null;
        TreeNode focusNode = root;
        while (focusNode != null) {
            parent = focusNode;
            if (focusNode.val <= val) {
                focusNode = focusNode.right;
            } else {
                focusNode = focusNode.left;
            }
        }
        if (parent.val <= val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return root;
    }

    /**
     * Insert recursive
     */
    private TreeNode insertNodeRecursive(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;

        if (val < root.val) {
            root.left = insertNodeRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertNodeRecursive(root.right, val);
        } else {
            // value already exists
            return root;
        }
        return root;
    }

    /**
     * Delete recursive
     */
    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.val) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.val = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }
        if (value < current.val) {
            current.left = deleteRecursive(current.left, value);
            return current;
        } else {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
    }

    /**
     * Find in BST Iterative - focus node
     */
    public boolean findIterative(TreeNode root, int value) {
        TreeNode focusNode = root;

        while (focusNode.val != value) {
            if (focusNode.val > value) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return false;
            }
        }
        return focusNode != null ? true : false;
    }

    /**
     * Find in BST Recursive
     */
    public boolean findRecursive(TreeNode current, int key) {
        if (current == null) {
            return false;
        }
        if (key == current.val) {
            return true;
        }
        return key < current.val ? findRecursive(current.left, key) : findRecursive(current.right, key);
    }

    /**
     * Find smallest value in BST - recursive
     */
    public int findSmallestValue(TreeNode root) {
        return root.left == null ? root.val : findSmallestValue(root.left);
    }
}
