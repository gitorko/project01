package com.demo.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListNodeUtil {

    public static ListNode create(int[] arr) {
        List<Integer> array = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        return create(array);
    }

    public static ListNode create(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }
        ListNode rootNode = new ListNode(arr.get(0));
        ListNode previousNode = rootNode;
        for (int i = 1; i < arr.size(); i++) {
            ListNode newNode = new ListNode(arr.get(i));
            previousNode.next = newNode;
            previousNode = newNode;
        }
        return rootNode;
    }

    public static int[] toArray(ListNode rootNode) {
        if (rootNode == null) {
            return new int[]{};
        }
        List<Integer> result = new ArrayList<>();
        ListNode tmp = rootNode;
        result.add(tmp.val);
        tmp = tmp.next;
        while (tmp != null) {
            result.add(tmp.val);
            tmp = tmp.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void display(ListNode rootNode) {
        if (rootNode == null) {
            return;
        }
        ListNode tmp = rootNode;
        System.out.print(tmp.val);
        tmp = tmp.next;
        while (tmp != null) {
            System.out.print(" --> " + tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void createLoopAt(ListNode node, int loopAt) {
        ListNode currNode = node;
        ListNode loopNode = null;
        int i = 0;
        while (currNode.next != null) {
            i++;
            if (i == loopAt) {
                System.out.println("Introducing loop at " + currNode);
                loopNode = currNode;
            }
            currNode = currNode.next;
        }
        currNode.next = loopNode;
    }
}
