package com.demo.basics.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement Doubly Linked List - EASY]()
 *
 * - left and right pointer
 */
public class CustomDoublyLinkedList {

    @Test
    public void test() {
        DoubleLinkList dl = new DoubleLinkList();
        for (int i = 1; i < 3; i++) {
            dl.addFirst(i);
        }
        for (int i = 4; i < 6; i++) {
            dl.addLast(i);
        }
        Assertions.assertEquals(Arrays.asList(2, 1, 4, 5), dl.getValues());
        dl.deleteFirst();
        Assertions.assertEquals(Arrays.asList(1, 4, 5), dl.getValues());
        dl.deleteLast();
        Assertions.assertEquals(Arrays.asList(1, 4), dl.getValues());
        Assertions.assertEquals(2, dl.counter);
    }

    @Test
    public void test2() {
        DoubleLinkList dl = new DoubleLinkList();
        dl.addFirst(10);
        Assertions.assertEquals(Arrays.asList(10), dl.getValues());
        dl.deleteLast();
        Assertions.assertEquals(Collections.emptyList(), dl.getValues());
        Assertions.assertEquals(0, dl.counter);
    }

    class DoubleLinkList {
        Node leftPointer;
        Node rightPointer;
        int counter;

        public Node addFirst(Integer val) {
            if (leftPointer == null) {
                leftPointer = new Node(val);
                rightPointer = leftPointer;
            } else {
                Node temp = leftPointer;
                leftPointer = new Node(val, null, temp);
                temp.left = leftPointer;
            }
            counter++;
            return leftPointer;
        }

        public Node addLast(Integer val) {
            if (rightPointer == null) {
                rightPointer = new Node(val);
                leftPointer = rightPointer;
            } else {
                Node temp = rightPointer;
                rightPointer = new Node(val, temp, null);
                temp.right = rightPointer;
            }
            counter++;
            return leftPointer;
        }

        public void deleteLast() {
            if (rightPointer == leftPointer) {
                leftPointer = null;
                rightPointer = null;
                counter--;
            }
            if (rightPointer != null) {
                rightPointer = rightPointer.left;
                if (rightPointer != null) {
                    rightPointer.right = null;
                }
                counter--;
            }
        }

        public void deleteFirst() {
            if (rightPointer == leftPointer) {
                leftPointer = null;
                rightPointer = null;
                counter--;
            }
            if (leftPointer != null) {
                leftPointer = leftPointer.right;
                if (leftPointer != null) {
                    leftPointer.left = null;
                }
                counter--;
            }
        }

        public Integer count() {
            return counter;
        }

        public List<Integer> getValues() {
            List<Integer> result = new ArrayList<>();
            Node curr = leftPointer;
            while (curr != null) {
                result.add(curr.val);
                curr = curr.right;
            }
            return result;
        }
    }

    class Node {
        public Integer val;
        public Node left;
        public Node right;

        public Node(Integer val) {
            this.val = val;
        }

        public Node(Integer val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
