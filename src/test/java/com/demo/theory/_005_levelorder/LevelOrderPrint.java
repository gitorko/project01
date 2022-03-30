package com.demo.theory._005_levelorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.demo.common.TreeNodeUtil;
import com.demo.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Level Order traversal using 2 queue
 * Level Order traversal using null delimiter
 *
 * Few other technique to do level order traversal, just for theory
 *
 * Technique 1:
 * Use 2 queue. Keep polling from q1 and offer to q2 till q1 is empty.
 * After that print a new line. Keep polling from q2 and offer to q1
 * till q2 is empty. Keep doing this still both q1 and q2 are empty.
 *
 * Technique 2
 * Use one queue with delimiter. Add a delimiter null after every level.
 * As soon as you encounter a null print a new line and add null at end of queue
 *
 * https://www.youtube.com/watch?v=vjt5Y6-1KsQ&ab_channel=TusharRoy-CodingMadeSimple
 */
public class LevelOrderPrint {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        levelByLevelTwoQueue(root);
        System.out.println("\n");
        levelByLevelOneQueueUsingDelimiter(root);
        System.out.println("\n");
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNodeUtil.printTree(root);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7));
        Assertions.assertEquals(expected, spiralWithTwoStack(root));
    }

    /**
     * Use two queue to print level by level
     */
    public void levelByLevelTwoQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                root = q1.poll();
                System.out.print(root.val + " ");
                if (root.left != null) {
                    q2.offer(root.left);
                }
                if (root.right != null) {
                    q2.offer(root.right);
                }
            }
            System.out.println();
            while (!q2.isEmpty()) {
                root = q2.poll();
                System.out.print(root.val + " ");
                if (root.left != null) {
                    q1.offer(root.left);
                }
                if (root.right != null) {
                    q1.offer(root.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * Use one queue and delimiter to print level by level
     */
    public void levelByLevelOneQueueUsingDelimiter(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) {
                System.out.print(root.val + " ");
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.offer(null);
                }
            }
        }
    }

    /**
     * Zigzag Two stack
     */
    public List<List<Integer>> spiralWithTwoStack(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            while (!s1.isEmpty()) {
                root = s1.pop();
                tmp.add(root.val);
                if (root.left != null) s2.push(root.left);
                if (root.right != null) s2.push(root.right);
            }
            result.add(tmp);
            tmp = new ArrayList<>();
            while (!s2.isEmpty()) {
                root = s2.pop();
                tmp.add(root.val);
                if (root.right != null) s1.push(root.right);
                if (root.left != null) s1.push(root.left);
            }
            if (!tmp.isEmpty()) result.add(tmp);
        }
        return result;
    }

    /**
     * ZigZag Deque with null delimiter to print tree in spiral order
     */
    public List<Integer> spiralWithOneDequeDelimiter(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(null);
        q.offerFirst(root);
        //if only delimiter(in this case null) is left in queue then break
        while (q.size() > 1) {
            root = q.peekFirst();
            while (root != null) {
                root = q.pollFirst();
                result.add(root.val);
                if (root.left != null) {
                    q.offerLast(root.left);
                }
                if (root.right != null) {
                    q.offerLast(root.right);
                }
                root = q.peekFirst();
            }
            root = q.peekLast();
            while (root != null) {
                result.add(root.val);
                root = q.pollLast();
                if (root.right != null) {
                    q.offerFirst(root.right);
                }
                if (root.left != null) {
                    q.offerFirst(root.left);
                }
                root = q.peekLast();
            }
        }
        return result;
    }

    /**
     * ZigZag One deque with count method to print tree in spiral order
     */
    public List<Integer> spiralWithOneDeque(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int count = 1;
        boolean flip = true;
        while (!deque.isEmpty()) {
            int currentCount = 0;
            while (count > 0) {
                if (flip) {
                    root = deque.pollFirst();
                    result.add(root.val);
                    if (root.left != null) {
                        deque.offerLast(root.left);
                        currentCount++;
                    }
                    if (root.right != null) {
                        deque.offerLast(root.right);
                        currentCount++;
                    }
                } else {
                    root = deque.pollLast();
                    result.add(root.val);
                    if (root.right != null) {
                        deque.offerFirst(root.right);
                        currentCount++;
                    }
                    if (root.left != null) {
                        deque.offerFirst(root.left);
                        currentCount++;
                    }
                }
                count--;
            }
            flip = !flip;
            count = currentCount;
        }
        return result;
    }
}
