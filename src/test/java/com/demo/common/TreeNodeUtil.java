package com.demo.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtil {

    public static TreeNode insertLevelOrder(List<Integer> nums) {
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(nums.get(index++));
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode temp = q.poll();
                if (index < nums.size()) {
                    Integer val = nums.get(index++);
                    if (val != null) {
                        temp.left = new TreeNode(val);
                        q.offer(temp.left);
                    }
                }
                if (index < nums.size()) {
                    Integer val = nums.get(index++);
                    if (val != null) {
                        temp.right = new TreeNode(val);
                        q.offer(temp.right);
                    }
                }
                size--;
            }
        }
        return root;
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root == null)
            return numLst;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            numLst.add(root.val);
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
        }
        return numLst;
    }

    public static List<Integer> levelOrderTraversalWithNull(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root == null)
            return numLst;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                root = q.poll();
                if (root == null) {
                    numLst.add(null);
                } else {
                    numLst.add(root.val);
                    if (root.left == null && root.right != null) {
                        q.add(null);
                    }
                    if (root.left != null) {
                        q.add(root.left);
                    }

                    if (root.right == null && root.left != null) {
                        q.add(null);
                    }
                    if (root.right != null) {
                        q.add(root.right);
                    }
                }
                size--;
            }
        }
        if (numLst.get(numLst.size() - 1) == null) {
            numLst.remove(numLst.size() - 1);
        }
        return numLst;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.add(root.val);
            numLst.addAll(preorderTraversal(root.left));
            numLst.addAll(preorderTraversal(root.right));
        }
        return numLst;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.addAll(inorderTraversal(root.left));
            numLst.add(root.val);
            numLst.addAll(inorderTraversal(root.right));
        }
        return numLst;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> numLst = new ArrayList<>();
        if (root != null) {
            numLst.addAll(postorderTraversal(root.left));
            numLst.addAll(postorderTraversal(root.right));
            numLst.add(root.val);
        }
        return numLst;
    }

    public static <T extends Comparable<?>> void printTree(TreeNode<T> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode<T>> newNodes = new ArrayList<>();
        for (TreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
