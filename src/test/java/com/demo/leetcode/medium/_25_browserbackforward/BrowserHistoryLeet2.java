package com.demo.leetcode.medium._25_browserbackforward;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1472. Design Browser History - MEDIUM](https://leetcode.com/problems/design-browser-history/)
 *
 * - 2 stack
 * - limitation: back and forward are O(n)
 *
 * https://www.youtube.com/watch?v=i1G-kKnBu8k&ab_channel=NeetCodeIO
 */
public class BrowserHistoryLeet2 {

    @Test
    public void test1() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        Assertions.assertEquals("facebook.com", browserHistory.back(1));
        Assertions.assertEquals("google.com", browserHistory.back(1));
        Assertions.assertEquals("facebook.com", browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        Assertions.assertEquals("linkedin.com", browserHistory.forward(2));
        Assertions.assertEquals("google.com", browserHistory.back(2));
        Assertions.assertEquals("leetcode.com", browserHistory.back(7));
    }

    class BrowserHistory {
        Stack<String> backwardStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        public BrowserHistory(String homepage) {
            backwardStack.push(homepage);
        }

        public void visit(String url) {
            backwardStack.push(url);
            //Throw away remaining items.
            forwardStack.clear();
        }

        public String back(int steps) {
            String url = "";
            //back history will always have one item
            while (backwardStack.size() > 1 && steps > 0) {
                url = backwardStack.pop();
                forwardStack.push(url);
                steps--;
            }
            return backwardStack.isEmpty() ? "" : backwardStack.peek();
        }

        public String forward(int steps) {
            String url = "";
            while (!forwardStack.isEmpty() && steps > 0) {
                url = forwardStack.pop();
                backwardStack.push(url);
                steps--;
            }
            return backwardStack.isEmpty() ? "" : backwardStack.peek();
        }
    }
}
