package com.demo.leetcode.medium._13_timebasedkeyvaluestore_981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [981. Time Based Key-Value Store - MEDIUM](https://leetcode.com/problems/time-based-key-value-store/)
 *
 * - binary search
 *
 * https://www.youtube.com/watch?v=fu2cD_6E8Hw&ab_channel=NeetCode
 */
public class TimeBasedKeyValueStore {

    @Test
    public void test() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        Assertions.assertEquals("bar", timeMap.get("foo", 1));
        // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        Assertions.assertEquals("bar", timeMap.get("foo", 3));
        // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.set("foo", "bar2", 4);
        Assertions.assertEquals("bar2", timeMap.get("foo", 4));
        Assertions.assertEquals("bar2", timeMap.get("foo", 5));
    }

    class TimeMap {
        Map<String, List<Pair>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pair> valueList = map.get(key);
            if (valueList == null)
                return "";

            int left = 0;
            int right = valueList.size() - 1;
            String result = "";
            while (left <= right) {
                int mid = (left + right) / 2;
                if (valueList.get(mid).timestamp > timestamp) {
                    right = mid - 1;
                } else {
                    result = valueList.get(mid).value;
                    left = mid + 1;
                }
            }
            return result;
        }
    }

    class Pair {
        public String value;
        public int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
