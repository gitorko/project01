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
 * - PRACTICE: P2
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

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode();
        ListNode rightHead = new ListNode();
        ListNode leftTail = leftHead;
        ListNode rightTail = rightHead;
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
        leftTail.next = rightHead.next;
        //Break the link and set to null
        rightTail.next = null;
        return leftHead.next;

    }
}
