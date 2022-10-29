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
public class BrowserHistoryLeet2 {

    @Test
    public void test1() {
        BrowserHistory browser = new BrowserHistory("web1");
        browser.visit("web2");
        browser.visit("web3");
        Assertions.assertEquals("web3", browser.getCurr());
        Assertions.assertEquals("web2", browser.back(1));
        Assertions.assertEquals("web1", browser.back(1));
        Assertions.assertEquals("web1", browser.back(1));
        Assertions.assertEquals("web1", browser.getCurr());
        Assertions.assertEquals("web2", browser.forward(1));
        Assertions.assertEquals("web3", browser.forward(1));
        Assertions.assertEquals("web3", browser.forward(1));
    }

    class BrowserHistory {
        int MAX_STEPS = 101;
        String[] history;
        int curr = 0;
        int last = 0;

        public String getCurr() {
            return history[curr];
        }

        public BrowserHistory(String homepage) {
            history = new String[MAX_STEPS];
            history[curr] = homepage;
        }

        public void visit(String url) {
            curr++;
            history[curr] = url;
            last = curr;
        }

        public String back(int steps) {
            curr -= steps;
            if (curr < 0) {
                curr = 0;
            }
            return history[curr];
        }

        public String forward(int steps) {
            curr += steps;
            if (curr > last) {
                curr = last;
            }

            return history[curr];
        }
    }
}
