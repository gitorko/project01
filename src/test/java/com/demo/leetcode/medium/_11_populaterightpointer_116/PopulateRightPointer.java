package com.demo.leetcode.medium._11_populaterightpointer_116;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [116. Populating Next Right Pointers in Each Node - MEDIUM](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
 *
 * - non-bfs
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=U4hFQCa1Cq0&ab_channel=NeetCode
 */
public class PopulateRightPointer {

    @Test
    public void test() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        connect(node);
        Assertions.assertEquals(3, node.left.next.val);
        Assertions.assertEquals(6, node.left.right.next.val);
    }

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
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
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

        public Node(int val) {
            this.val = val;
        }
    }
}
