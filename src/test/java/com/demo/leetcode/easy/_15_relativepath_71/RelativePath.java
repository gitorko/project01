package com.demo.leetcode.easy._15_relativepath_71;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [71. Simplify Path - EASY](https://leetcode.com/problems/simplify-path/)
 *
 * - use stack
 * - PRACTICE: P2
 *
 * https://www.youtube.com/watch?v=qYlHrAKJfyA&ab_channel=NeetCode
 */
public class RelativePath {

    @Test
    public void test() {
        Assertions.assertEquals("/a/c", simplifyPath("/a/b/.././c"));
        Assertions.assertEquals("/c", simplifyPath("/.././c"));
        Assertions.assertEquals("/", simplifyPath("/../"));
        Assertions.assertEquals("/a/bd/ef", simplifyPath("/./a/bd/ef/./gh/.."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String tokens[] = path.split("/");
        for (String token : tokens) {
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (token.equals(".") || token.equals("")) {
                //do nothing
            } else {
                stack.push(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        String result = sb.toString();
        return result.isBlank() ? "/" : result;
        //return "/" + String.join("/", stack);
    }

}
