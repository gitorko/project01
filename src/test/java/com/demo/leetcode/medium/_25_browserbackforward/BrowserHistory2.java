package com.demo.leetcode.medium._25_browserbackforward;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement browser back and forward data structure - MEDIUM]()
 *
 * - double link list
 */
public class BrowserHistory2 {

    @Test
    public void test1() {
        Browser browser = new Browser();
        browser.visit("web1");
        browser.visit("web2");
        browser.visit("web3");
        Assertions.assertEquals("web3", browser.current());
        Assertions.assertEquals("web2", browser.back());
        Assertions.assertEquals("web1", browser.back());
        Assertions.assertEquals("", browser.back());
        Assertions.assertEquals("web1", browser.current());
        Assertions.assertEquals("web2", browser.forward());
        Assertions.assertEquals("web3", browser.forward());
        Assertions.assertEquals("", browser.forward());
    }

    @Test
    public void test2() {
        Browser browser = new Browser();
        browser.visit("web1");
        browser.visit("web2");
        browser.visit("web3");
        Assertions.assertEquals("web2", browser.back());
        browser.visit("web4");
        Assertions.assertEquals("web4", browser.current());
        Assertions.assertEquals("web2", browser.back());
        Assertions.assertEquals("web1", browser.back());
        Assertions.assertEquals("", browser.back());
        Assertions.assertEquals("web1", browser.current());
        Assertions.assertEquals("web2", browser.forward());
        Assertions.assertEquals("web4", browser.forward());
        Assertions.assertEquals("", browser.forward());
    }

    @AllArgsConstructor
    class HistoryNode {
        String url;
        HistoryNode previous;
        HistoryNode forward;
    }

    class Browser {
        HistoryNode curr;

        public void visit(String url) {
            if (curr == null) {
                curr = new HistoryNode(url, null, null);
            } else {
                curr.forward = new HistoryNode(url, curr, null);
                curr = curr.forward;
            }
        }

        public String back() {
            String url = "";
            if (curr != null && curr.previous != null) {
                curr = curr.previous;
                url = curr.url;
            }
            return url;
        }

        public String forward() {
            String url = "";
            if (curr != null && curr.forward != null) {
                curr = curr.forward;
                url = curr.url;
            }
            return url;
        }

        public String current() {
            if (curr != null) {
                return curr.url;
            }
            return "";
        }
    }
}
