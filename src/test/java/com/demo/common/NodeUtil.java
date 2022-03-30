package com.demo.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodeUtil {

    public static Node buildGraph(int[][] input) {
        Map<Integer, Node> visited = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            visited.put(i + 1, new Node(i + 1));
        }

        for (int i = 0; i < input.length; i++) {
            Node parent = visited.get(i + 1);
            Node n1 = visited.get(input[i][0]);
            Node n2 = visited.get(input[i][1]);
            parent.neighbors.add(n1);
            parent.neighbors.add(n2);
        }
        return visited.get(1);
    }

    public static String getGraph(Node node) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Node> visited = new HashMap();
        visited.put(node.val, node);
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            sb.append(currNode.val);
            sb.append(",");
            for (Node neighbor : currNode.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
            }
        }
        return sb.toString();
    }
}
