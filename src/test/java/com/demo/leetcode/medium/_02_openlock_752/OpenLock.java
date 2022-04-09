package com.demo.leetcode.medium._02_openlock_752;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [752. Open the Lock - MEDIUM](https://leetcode.com/problems/open-the-lock/)
 *
 * - bfs
 * - visited and dead ends are treated same.
 *
 * https://www.youtube.com/watch?v=Pzg3bCDY87w&ab_channel=NeetCode
 */
public class OpenLock {

    @Test
    public void test() {
        String deadends[] = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        Assertions.assertEquals(6, openLock(deadends, target));
    }

    /**
     * Time: O(10^4)
     * Space: O(10^4)
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int depth = 0;
        queue.addAll(Arrays.asList("0000"));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String node = queue.poll();
                //if match return
                if (node.equals(target))
                    return depth;
                //if already visited continue
                if (visited.contains(node)) {
                    size--;
                    continue;
                }
                visited.add(node);
                queue.addAll(getSuccessors(node));
                size--;
            }
            depth++;
        }
        return -1;
    }

    private List<String> getSuccessors(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return res;
    }
}
