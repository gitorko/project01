package com.demo.leetcode.easy._10_deletenodelinklist_203;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [203. Remove Linked List Elements - EASY](https://leetcode.com/problems/remove-linked-list-elements/)
 *
 * - dummy node
 * - PRACTICE: P3
 *
 * https://www.youtube.com/watch?v=JI71sxtHTng&ab_channel=NeetCode
 */
public class DeleteNodeLinkedList {

    @Test
    public void test1() {
        int arr[] = {4, 5, 1, 9};
        int expected[] = {4, 5, 1};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeElements(rootNode, 9);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    @Test
    public void test2() {
        int arr[] = {4, 5, 1, 9};
        int expected[] = {5, 1, 9};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeElements(rootNode, 4);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    @Test
    public void test3() {
        int arr[] = {4, 5, 1, 9};
        int expected[] = {4, 5, 9};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeElements(rootNode, 1);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    @Test
    public void test4() {
        int arr[] = {1, 2, 6, 3, 4, 5, 6};
        int expected[] = {1, 2, 3, 4, 5};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeElements(rootNode, 6);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    @Test
    public void test5() {
        int arr[] = {7, 7, 7, 7};
        int expected[] = {};
        ListNode rootNode = ListNodeUtil.create(arr);
        rootNode = removeElements(rootNode, 7);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(rootNode));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
