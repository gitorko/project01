package com.demo.leetcode.medium._25_browserbackforward;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1472. Design Browser History - MEDIUM](https://leetcode.com/problems/design-browser-history/)
 *
 * - arrays
 * - optimal because forward and back are O(1)
 *
 * https://www.youtube.com/watch?v=i1G-kKnBu8k&ab_channel=NeetCodeIO
 */
public class BrowserHistoryLeet3 {

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

        /**
         * Time: O(1)
         */
        public void visit(String url) {
            curr++;
            history[curr] = url;
            last = curr;
        }

        /**
         * Time: O(1)
         */
        public String back(int steps) {
            curr -= steps;
            //out of bounds check
            if (curr < 0) {
                curr = 0;
            }
            return history[curr];
        }

        /**
         * Time: O(1)
         */
        public String forward(int steps) {
            curr += steps;
            //out of bounds check
            if (curr > last) {
                curr = last;
            }
            return history[curr];
        }
    }
}
