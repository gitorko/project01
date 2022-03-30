package com.demo.leetcode.medium._10_insertionsortlinklist_147;

import java.time.Duration;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [147. Insertion Sort List - MEDIUM](https://leetcode.com/problems/insertion-sort-list/)
 *
 * - pointer
 * - most likely to mess up on pointer switch
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=Kk6mXAzqX3Y&ab_channel=NeetCode
 */
public class InsertionSortLinkList {

    @Test
    public void test1() {
        int[] arr = {4, 2, 1, 3};
        int[] expected = {1, 2, 3, 4};
        ListNode rootNode = ListNodeUtil.create(arr);
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(insertionSortList(rootNode)));
        });
    }

    @Test
    public void test2_negativeNum() {
        int[] arr = {-1, 5, 3, 4, 0};
        int[] expected = {-1, 0, 3, 4, 5};
        ListNode rootNode = ListNodeUtil.create(arr);
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(insertionSortList(rootNode)));
        });
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            //already in order
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }

            //Start from beginning and find the right position to insert
            //temp stops one node behind
            ListNode temp = dummy;
            while (curr.val > temp.next.val) {
                temp = temp.next;
            }

            //insert and fix pointers
            prev.next = curr.next;
            //every likely to put previous here, but note that its temp.next and not previous
            //error will happen if you have just 3 nodes in example
            curr.next = temp.next;
            temp.next = curr;
            curr = prev.next;
        }

        return dummy.next;
    }
}
