package com.demo.leetcode.medium._11_populaterightpointer_116;

/**
 * [Populating Next Right Pointers in Each Node - MEDIUM](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
 *
 * https://www.youtube.com/watch?v=U4hFQCa1Cq0&ab_channel=NeetCode
 */
public class PopulateRightPointer {

    /**
     * Not using BFS as takes O(n) space. The below algo takes O(1) space
     * Time: O(n)
     * Space: O(1)
     */
    public Node connect(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}
