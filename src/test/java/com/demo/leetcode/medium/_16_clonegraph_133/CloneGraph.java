package com.demo.leetcode.medium._16_clonegraph_133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.demo.common.Node;
import com.demo.common.NodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [133. Clone Graph - MEDIUM](https://leetcode.com/problems/clone-graph/)
 *
 * - bfs, visited map
 * - PRACTICE: P1
 *
 * https://www.youtube.com/watch?v=mQeF6bN8hMk&ab_channel=NeetCode
 */
public class CloneGraph {

    @Test
    public void test() {
        int[][] input = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node node = NodeUtil.buildGraph(input);
        Node actual = cloneGraph(node);
        Assertions.assertEquals("1,2,4,3,", NodeUtil.getGraph(actual));
    }

    /**
     * Time: O(∣V∣+∣E∣)
     * Space: O(∣V∣+∣E∣)
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val);
        Map<Integer, Node> visited = new HashMap();
        visited.put(node.val, newNode);

        Queue<Node> queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for (Node neighbor : currNode.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                //add neighbour to new created nodes
                visited.get(currNode.val).neighbors.add(visited.get(neighbor.val));
            }
        }
        return newNode;
    }
}
