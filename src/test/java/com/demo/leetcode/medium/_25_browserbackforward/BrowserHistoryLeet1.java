package com.demo.leetcode.medium._25_browserbackforward;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1472. Design Browser History - MEDIUM](https://leetcode.com/problems/design-browser-history/)
 *
 * - doubly linked list
 * - limitation: back and forward are O(n)
 *
 * https://www.youtube.com/watch?v=i1G-kKnBu8k&ab_channel=NeetCodeIO
 */
public class BrowserHistoryLeet1 {

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
        HistoryNode curr;

        class HistoryNode {
            String url;
            HistoryNode previous;
            HistoryNode forward;

            public HistoryNode(String url, HistoryNode previous, HistoryNode forward) {
                this.url = url;
                this.previous = previous;
                this.forward = forward;
            }
        }

        public BrowserHistory(String homepage) {
            curr = new HistoryNode(homepage, null, null);
        }

        /**
         * Time: O(1)
         */
        public void visit(String url) {
            curr.forward = new HistoryNode(url, curr, null);
            curr = curr.forward;
        }

        /**
         * Time: O(n)
         */
        public String back(int steps) {
            while (curr.previous != null && steps > 0) {
                curr = curr.previous;
                steps--;
            }
            return curr.url;
        }

        /**
         * Time: O(n)
         */
        public String forward(int steps) {
            while (curr.forward != null && steps > 0) {
                curr = curr.forward;
                steps--;
            }
            return curr.url;
        }
    }
}
