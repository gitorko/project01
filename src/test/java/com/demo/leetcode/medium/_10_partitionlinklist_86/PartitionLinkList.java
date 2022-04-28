package com.demo.leetcode.medium._10_partitionlinklist_86;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [86. Partition List - MEDIUM](https://leetcode.com/problems/partition-list/)
 *
 * - 4 dummy node
 * - set rightTail.next to null
 *
 * PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=KT1iUciJr4g&ab_channel=NeetCode
 */
public class PartitionLinkList {

    @Test
    public void test() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 4, 3, 2, 5, 2));
        int[] expected = {1, 2, 2, 4, 3, 5};
        ListNode partition = partition(root, 3);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(partition));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode leftStart = new ListNode(0);
        ListNode rightStart = new ListNode(0);
        ListNode leftTail = leftStart;
        ListNode rightTail = rightStart;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightStart.next;
        rightTail.next = null;
        return leftStart.next;

    }
}
