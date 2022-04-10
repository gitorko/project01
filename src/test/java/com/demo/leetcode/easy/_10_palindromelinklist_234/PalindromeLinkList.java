package com.demo.leetcode.easy._10_palindromelinklist_234;

import java.util.Arrays;

import com.demo.common.ListNode;
import com.demo.common.ListNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [234. Palindrome Linked List - EASY](https://leetcode.com/problems/palindrome-linked-list/)
 *
 * - find min, reverse, check
 * - fast & slow pointer
 * - reverse link list mid to end.
 *
 * PRACTICE
 *
 * https://www.youtube.com/watch?v=yOzXms1J6Nk&ab_channel=NeetCode
 */
public class PalindromeLinkList {

    @Test
    public void test() {
        ListNode root = ListNodeUtil.create(Arrays.asList(1, 2, 2, 1));
        Assertions.assertTrue(isPalindrome(root));
    }

    public boolean isPalindrome(ListNode head) {
        //find middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse 2nd half
        slow = reverse(slow);
        fast = head;

        //check if palindrome
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
