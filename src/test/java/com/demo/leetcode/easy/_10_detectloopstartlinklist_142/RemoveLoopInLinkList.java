package com.demo.leetcode.easy._10_detectloopstartlinklist_142;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [142. Linked List Cycle II - EASY](https://leetcode.com/problems/linked-list-cycle-ii/)
 *
 * - fast & slow pointer. Floyd Cycle Detection algorithm
 *
 * https://www.youtube.com/watch?v=gBTe7lFR3vc&ab_channel=NeetCode
 */
public class RemoveLoopInLinkList {

    @Test
    public void test1() {
        int arr[] = {1, 2, 3, 4};
        ListNode rootNode = ListNodeUtil.create(arr);
        ListNodeUtil.createLoopAt(rootNode, 2);
        Assertions.assertEquals(2, detectCycle(rootNode).getVal());
    }

    /**
     * Floyd algo, fast and slow pointer
     * Time: O(N)
     * Space: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                //set to null to remove loop
                return slow;
            }
        }
        return null;
    }

}
