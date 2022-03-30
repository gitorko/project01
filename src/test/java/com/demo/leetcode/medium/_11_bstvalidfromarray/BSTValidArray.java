package com.demo.leetcode.medium._11_bstvalidfromarray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Check Level Order Traversal of BST - MEDIUM]()
 *
 * - bfs with max,min
 *
 * PRACTICE
 */
public class BSTValidArray {

    @Test
    public void test_isBST() {
        List<Integer> nums = Arrays.asList(5, 2, 7, 1, null, 6, 9);
        Assertions.assertTrue(checkLevelOrderTraversalRepresentBST(nums));
    }

    @Test
    public void test_isBST_invalid() {
        List<Integer> nums = Arrays.asList(5, 2, 7, 1, null, 4, 9);
        Assertions.assertFalse(checkLevelOrderTraversalRepresentBST(nums));
    }

    public boolean checkLevelOrderTraversalRepresentBST(List<Integer> nums) {
        Queue<NodeDetails> q = new LinkedList<>();
        int index = 0;
        q.add(new NodeDetails(nums.get(index++), Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (index != nums.size() && q.size() > 0) {
            NodeDetails curr = q.poll();

            //left side
            if (index < nums.size() && nums.get(index) == null) {
                index++;
            } else if (index < nums.size() && curr.minSoFar < nums.get(index) && nums.get(index) < curr.val) {
                q.add(new NodeDetails(nums.get(index++), curr.minSoFar, curr.val));
            }

            //right side
            if (index < nums.size() && nums.get(index) == null) {
                index++;
            } else if (index < nums.size() && curr.maxSoFar > nums.get(index) && nums.get(index) > curr.val) {
                q.add(new NodeDetails(nums.get(index++), curr.val, curr.maxSoFar));
            }
        }
        return (index == nums.size());
    }

    @AllArgsConstructor
    class NodeDetails {
        int val;
        int minSoFar, maxSoFar;
    }
}
