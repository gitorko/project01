package com.demo.leetcode.hard._10_reversenodeskgroup_25;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [25. Reverse Nodes in k-Group - HARD](https://leetcode.com/problems/reverse-nodes-in-k-group/)
 *
 * - group previous, get kth
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=1UOPsfP85V4&ab_channel=NeetCode
 */
public class ReverseNodeKGroups {

    @Test
    public void test() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 3, 4, 5));
        int[] expected = {2, 1, 4, 3, 5};
        root = reverseKGroup(root, 2);
        Assertions.assertArrayEquals(expected, ListNodeUtil.toArray(root));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode currGroupStart = dummy;
        ListNode nextGroupStart;
        while (true) {
            ListNode kthNode = getKth(currGroupStart, k);
            if (kthNode == null) {
                break;
            }
            nextGroupStart = kthNode.next;
            //reverse
            ListNode prev = nextGroupStart;
            ListNode curr = currGroupStart.next;
            ListNode temp;
            while (curr != nextGroupStart) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            //confusing part, currGroupStart needs to go one node behind the nextGroupStart
            temp = currGroupStart.next;
            currGroupStart.next = kthNode;
            currGroupStart = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}
