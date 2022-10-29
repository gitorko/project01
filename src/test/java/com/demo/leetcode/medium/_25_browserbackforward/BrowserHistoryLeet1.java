package com.demo.leetcode.medium._25_browserbackforward;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1472. Design Browser History - MEDIUM](https://leetcode.com/problems/design-browser-history/)
 *
 * - doubly linked list
 *
 * https://www.youtube.com/watch?v=i1G-kKnBu8k&ab_channel=NeetCodeIO
 */
public class BrowserHistoryLeet1 {

    @Test
    public void test1() {
        BrowserHistory browser = new BrowserHistory("web1");
        browser.visit("web2");
        browser.visit("web3");
        Assertions.assertEquals("web3", browser.curr.url);
        Assertions.assertEquals("web2", browser.back(1));
        Assertions.assertEquals("web1", browser.back(1));
        Assertions.assertEquals("web1", browser.back(1));
        Assertions.assertEquals("web1", browser.curr.url);
        Assertions.assertEquals("web2", browser.forward(1));
        Assertions.assertEquals("web3", browser.forward(1));
        Assertions.assertEquals("web3", browser.forward(1));
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

        public void visit(String url) {
            curr.forward = new HistoryNode(url, curr, null);
            curr = curr.forward;
        }

        public String back(int steps) {
            while (curr.previous != null && steps > 0) {
                curr = curr.previous;
                steps--;
            }
            return curr.url;
        }

        public String forward(int steps) {
            while (curr.forward != null && steps > 0) {
                curr = curr.forward;
                steps--;
            }
            return curr.url;
        }
    }
}
