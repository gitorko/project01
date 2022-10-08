package com.demo.leetcode.medium._10_copylistrandompointer_138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * [138. Copy List with Random Pointer - MEDIUM](https://leetcode.com/problems/copy-list-with-random-pointer/)
 *
 * - map for nodes, 2 loops
 * - PRACTICE: P4
 *
 * https://www.youtube.com/watch?v=5Y2EiZST97Y&ab_channel=NeetCode
 */
public class CopyListRandomPointer {

    @Test
    public void test() {
        Integer[][] input = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        List<Node> list = new ArrayList<>();
        Node previous = null;
        //create nodes
        for (int i = 0; i < input.length; i++) {
            Node currNode = new Node(input[i][0]);
            if (previous != null) {
                previous.next = currNode;
            }
            list.add(currNode);
            previous = currNode;
        }
        //fix random pointer
        for (int i = 0; i < input.length; i++) {
            if (input[i][1] != null) {
                list.get(i).random = list.get(input[i][1]);
            }
        }
        Node copyNode = copyRandomList(list.get(0));
        copyNode.display(copyNode);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    class Node {
        final int val;
        Node random;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public void display(Node currNode) {
            while (currNode != null) {
                System.out.println(currNode.val + " " + (null == currNode.random ? null : currNode.random.val));
                currNode = currNode.next;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

}


