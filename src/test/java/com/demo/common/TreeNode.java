package com.demo.common;

import java.util.Objects;

public class TreeNode<T extends Comparable<?>> {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(val, treeNode.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + "]";
    }
}
