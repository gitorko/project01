package com.demo.leetcode.medium._25_browserbackforward;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [Implement browser back and forward data structure - MEDIUM]()
 *
 * - stack
 * - limitation: will not allow additional ops like delete random url in O(1) time.
 */
public class BrowserHistory1 {

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

    class Browser {
        Stack<String> historyStack = new Stack<>();
        Stack<String> tempStack = new Stack<>();

        public void visit(String url) {
            historyStack.push(url);
            //Throw away remaining items.
            tempStack.clear();
        }

        public String back() {
            String url = "";
            if (!historyStack.isEmpty() && historyStack.size() > 1) {
                tempStack.push(historyStack.pop());
                if (!historyStack.isEmpty())
                    url = historyStack.peek();
            }
            return url;
        }

        public String forward() {
            String url = "";
            if (!tempStack.isEmpty()) {
                url = tempStack.pop();
                historyStack.push(url);
            }
            return url;
        }

        public String current() {
            if (!historyStack.isEmpty()) {
                return historyStack.peek();
            }
            return "";
        }
    }

}
