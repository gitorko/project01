package com.demo.leetcode.easy._10_detectlooplinklist_141;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [141. Linked List Cycle - EASY](https://leetcode.com/problems/linked-list-cycle/)
 *
 * - fast & slow pointer. Floyd Cycle Detection algorithm
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=gBTe7lFR3vc&ab_channel=NeetCode
 */
public class DetectLoopInLinkList {

    @Test
    public void test() {
        int arr[] = {1, 2, 3, 4};
        ListNode rootNode = ListNodeUtil.create(arr);
        ListNodeUtil.createLoopAt(rootNode, 2);
        Assertions.assertTrue(hasCycle(rootNode));
    }

    /**
     * Floyd algo, fast and slow pointer
     * Time: O(N)
     * Space: O(1)
     */
    public Boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
