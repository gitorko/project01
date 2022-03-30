package com.demo.leetcode.medium._11_btdistributecoins_979;

import java.util.Arrays;

import com.demo.common.TreeNode;
import com.demo.common.TreeNodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [979. Distribute Coins in Binary Tree - MEDIUM](https://leetcode.com/problems/distribute-coins-in-binary-tree/)
 *
 * - math.abs sum
 * - subtract -1 from final sum
 */
public class DistributeCoins {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.insertLevelOrder(Arrays.asList(3, 0, 0));
        Assertions.assertEquals(2, distributeCoins(root));
    }

    /**
     * Time: O(n)
     * Space: O(h)
     *
     *  if we get '+3' from the left child, that means that the left subtree has 3 extra coins to move out.
     *  If we get '-1' from the right child, we need to move 1 coin in.
     *  So, we increase the number of moves by 4 (3 moves out left + 1 moves in right).
     */
    int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
