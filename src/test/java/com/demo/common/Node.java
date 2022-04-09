package com.demo.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public int getVal() {
        return val;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < neighbors.size(); i++) {
            sb.append(neighbors.get(i).val);
            sb.append(",");
        }
        return "Node{" +
                "val=" + val +
                ", neighbors=" + sb.toString() +
                '}';
    }
}
