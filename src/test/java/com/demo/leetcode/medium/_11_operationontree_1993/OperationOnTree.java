package com.demo.leetcode.medium._11_operationontree_1993;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1993. Operations on Tree - MEDIUM](https://leetcode.com/problems/operations-on-tree/)
 *
 * - dfs
 * - input is parent node
 *
 * https://www.youtube.com/watch?v=qK4PtjrVD0U&ab_channel=NeetCode
 */
public class OperationOnTree {

    @Test
    public void test() {
        int[] nums = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(nums);
        // return true because node 2 is unlocked.
        // Node 2 will now be locked by user 2.
        Assertions.assertTrue(lockingTree.lock(2, 2));
        // return false because user 3 cannot unlock a node locked by user 2.
        Assertions.assertFalse(lockingTree.unlock(2, 3));
        // return true because node 2 was previously locked by user 2.
        // Node 2 will now be unlocked.
        Assertions.assertTrue(lockingTree.unlock(2, 2));
        // return true because node 4 is unlocked.
        // Node 4 will now be locked by user 5.
        Assertions.assertTrue(lockingTree.lock(4, 5));
        // return true because node 0 is unlocked and has at least one locked descendant (node 4).
        // Node 0 will now be locked by user 1 and node 4 will now be unlocked.
        Assertions.assertTrue(lockingTree.upgrade(0, 1));
        // return false because node 0 is already locked.
        Assertions.assertFalse(lockingTree.lock(0, 1));
    }

    class LockingTree {
        int[] parent;
        Map<Integer, List<Integer>> children;
        //[node,user]
        Map<Integer, Integer> locked;

        public LockingTree(int[] parent) {
            int n = parent.length;
            children = new HashMap<>();
            locked = new HashMap<>();
            this.parent = parent;

            for (int i = 0; i < n; i++)
                children.put(i, new ArrayList<>());
            for (int i = 1; i < n; i++)
                children.get(parent[i]).add(i);
        }

        public boolean lock(int num, int user) {
            //if no lock held lock for user
            if (locked.containsKey(num)) return false;
            locked.put(num, user);
            return true;
        }

        public boolean unlock(int num, int user) {
            //contains lock, lock is held by same user then unlock
            if (!locked.containsKey(num) || locked.get(num) != user) return false;
            locked.remove(num, user);
            return true;
        }

        public boolean upgrade(int num, int user) {
            //if node holds a lock return
            if (locked.containsKey(num)) return false;

            // check if all the ancestor nodes are unlocked.
            int curr = num;
            while (curr != -1) {
                curr = parent[curr];
                if (locked.containsKey(curr))
                    return false;
            }

            // check if num has at least one locked descendant
            int tmp = locked.size();
            dfs(num);
            if (tmp == locked.size()) return false;

            locked.put(num, user);
            return true;
        }

        public void dfs(int src) {
            if (locked.containsKey(src))
                locked.remove(src);
            for (int nbr : children.get(src))
                dfs(nbr);
        }
    }
}
