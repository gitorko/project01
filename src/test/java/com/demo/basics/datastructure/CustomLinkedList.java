package com.demo.basics.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [707. Design Linked List - MEDIUM](https://leetcode.com/problems/design-linked-list/)
 *
 * https://www.youtube.com/watch?v=Wf4QhpdVFQo&ab_channel=NeetCodeIO
 */
public class CustomLinkedList {

    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        Assertions.assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);  // now the linked list is 1->3
        Assertions.assertEquals(3, myLinkedList.get(1));
    }

    class MyLinkedList {

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private int size;

        public MyLinkedList() {
        }

        //case1: out of bounds
        //case2: get
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        //case1: empty list
        //case2: append to front
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
            } else {
                Node node = new Node(val);
                node.next = head;
                head = node;
            }
            size++;
        }

        //case1: empty list
        //case2: add to end
        public void addAtTail(int val) {
            if (head == null) {
                head = new Node(val);
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new Node(val);
            }
            size++;
        }

        //case1: if index equals size linked list, append to end.
        //case2: if index is 0 or less than 0, add to head.
        //case3: if index is greater than the length, the node will not be inserted.
        //case4: add at beginning
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node curr = head;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                Node node = new Node(val);
                node.next = curr.next;
                curr.next = node;
                size++;
            }
        }

        //case1: out of bounds
        //case2: delete head
        //case3: delete middle
        //case4: delete last
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
    }
}
