package com.demo.leetcode.medium._10_swapnodepairlinklist_24;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [24. Swap Nodes in Pairs - MEDIUM](https://leetcode.com/problems/swap-nodes-in-pairs/)
 *
 * - dummy node
 * - double jump, as you need min 2 nodes to swap
 * - edge case when last node has no pair
 *
 * PRACTICE
 */
public class SwapNodeLinkList {

    @Test
    public void test1() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 3, 4));
        int[] expected = {2, 1, 4, 3};
        root = swapPairs(root);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    @Test
    public void test_lastNodeNoPair() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 3));
        int[] expected = {2, 1, 3};
        root = swapPairs(root);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    @Test
    public void test1_recursion() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 3, 4));
        int[] expected = {2, 1, 4, 3};
        root = swapPairsRecursion(root);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    @Test
    public void test2_recursion() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2));
        int[] expected = {2, 1};
        root = swapPairsRecursion(root);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            //swap logic
            first.next = second.next;
            current.next = second;
            second.next = first;

            //double jump
            current = current.next.next;

        }
        return dummy.next;
    }

    /**
     * Recursion
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode swapPairsRecursion(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode tempNext = head.next;
        //double jump
        head.next = swapPairs(head.next.next);
        tempNext.next = head;
        return tempNext;
    }
}
